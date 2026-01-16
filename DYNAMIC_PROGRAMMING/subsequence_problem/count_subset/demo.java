import java.util.*;

public class demo {

    // Recursion
    public static int countSubsetRec(int[] arr, int k) {
        // code here
        return helperRec(arr.length-1,k,arr);
    }
    
    public static int helperRec(int i,int k,int[] arr){
        if(i < 0){
            return (k == 0) ? 1 : 0;
        }
        
        int notTake = helperRec(i-1,k,arr);
        int take = helperRec(i-1,k-arr[i],arr);
        
        return take + notTake;
    }
    // TC = O(2^n)
    // SC = O(n)



    // Memoization
    // Function to calculate the number of subsets with a given sum
    public static int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length][target+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        return helperRec(nums.length-1,target,nums,dp);
    }
    public static int helperRec(int i,int k,int[] arr,int[][] dp){
        
        if(i < 0){
            return k == 0 ? 1 : 0;
        }
                
        if(dp[i][k] != -1) return dp[i][k];
        
        int notTake = helperRec(i-1,k,arr,dp);
        int take = 0;
        if(k >= arr[i]){
            take = helperRec(i-1,k-arr[i],arr,dp);
        }
        
        return dp[i][k] = take + notTake;
    }

}
