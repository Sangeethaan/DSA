import java.util.*;

public class demo {
    // recusion
    public static int minimumDifference(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        return helper(nums.length-1,0,0,nums,totalSum);
    }

    public static int helper(int i,int A,int sumA,int[] nums,int totalSum){
        if(i < 0){
            return (A == nums.length/2) ? Math.abs(sumA - (totalSum - sumA)) : Integer.MAX_VALUE;
        }

        int notTake = helper(i-1,A,sumA,nums,totalSum);
        int take = Integer.MAX_VALUE;
        if(A < nums.length/2 && (A + (i+1)) >= nums.length/2){
            take = helper(i-1,A+1,sumA+nums[i],nums,totalSum);
        }
        

        return Math.min(notTake, take);
    }
    // TC = O(2^n)
    // SC= O(n)
    public static void main(String[] args) {
        int arr[] = {2,-1,0,4,-2,-9};
        System.out.println(minimumDifference(arr));
    }
}
