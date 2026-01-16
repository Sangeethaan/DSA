import java.util.*;

public class demo {
    // Recursion
    public static int frogJump(int[] heights, int k) {
        return helper(heights.length-1,heights,k);
    }

    public static int helper(int i,int[] heights,int k){
        if(i==0) return 0;
        int minStep = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(i-j >= 0){
                int jump = helper(i-j, heights, k) + Math.abs(heights[i] - heights[i-j]);
                minStep = Integer.min(minStep, jump);
            }else{
                break;
            }  
        }

        return minStep;
    }
    // TC = O(k^n)
    // SC = O(n) recursion stack

    // Memoization
    public static int frogJump1(int[] heights, int k) {
        int dp[] = new int[heights.length];
        Arrays.fill(dp, -1);
        return helper1(heights.length-1,heights,k,dp);
    }

    public static int helper1(int i,int[] heights,int k,int[] dp){
        if(i==0) return 0;
        if(dp[i] != -1) return dp[i];

        int minStep = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(i-j >= 0){
                int jump = helper1(i-j, heights, k,dp) + Math.abs(heights[i] - heights[i-j]);
                minStep = Integer.min(minStep, jump);
            }else{
                break;
            }  
        }

        return dp[i] = minStep;
    }
    // TC = O(n.k)
    // SC = O(n) recursion stack + O(n) dp array

    // tabulation
    public static int frogJumpTabulation(int[] heights, int k) {
        int dp[] = new int[heights.length];
        dp[0] = 0;

        for(int i=1;i<heights.length;i++){
            int minStep = Integer.MAX_VALUE;

            for(int j=1;j<=k;j++){
                if(i-j >= 0){
                    int jump = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    minStep = Integer.min(minStep, jump);
                }else{
                    break;
                }  
            }
            dp[i] = minStep;
        }

        return dp[heights.length-1];
    }
    // TC = O(n.k)
    // SC = O(n){dp array}

    public static void main(String[] args) {
        int[] heights = {10, 5, 20, 0, 15};
        int k = 2;
        System.out.println(frogJump(heights, k));
    }
}
