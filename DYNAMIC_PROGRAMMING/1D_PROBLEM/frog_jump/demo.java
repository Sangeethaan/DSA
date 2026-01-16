import java.util.*;

class demo {
    public static int minCost(int[] height) {
        // code here
        return helper(height.length-1,height);
    }
    public static int helper(int i,int[] height){
        if(i == 0) return 0;

        int oneStep = helper(i-1, height) + Math.abs(height[i]-height[i-1]);

        int twoStep = Integer.MAX_VALUE;
        if (i > 1) {
            twoStep = helper(i-2, height) + Math.abs(height[i]-height[i-2]);
        }

        return Math.min(oneStep, twoStep);
    }

    // TC = O(2^n)
    // SC = O(n){recursion space}

    // Memoization
    public static int minCostMemoization(int[] height) {
        // code here
        int dp[] = new int[height.length];
        Arrays.fill(dp, -1);
        return helperMemoization(height.length-1,height,dp);
    }
    public static int helperMemoization(int i,int[] height,int[] dp){
        if(i == 0) return 0;

        if(dp[i] != -1) return dp[i];

        int oneStep = helperMemoization(i-1, height,dp) + Math.abs(height[i]-height[i-1]);

        int twoStep = Integer.MAX_VALUE;
        if (i > 1) {
            twoStep = helperMemoization(i-2, height,dp) + Math.abs(height[i]-height[i-2]);
        }

        return dp[i] = Math.min(oneStep, twoStep);
    }
    // TC = O(n)
    // SC = O(n){recursion stack} + O(n){dp array}

    public static int minCost1(int[] height) {
        int dp[] = new int[height.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1;i<height.length;i++){
            int oneStep = dp[i-1] + Math.abs(height[i] - height[i-1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp[i-2] + Math.abs(height[i]-height[i-2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[height.length-1]; 
    }
    // TC = O(n)
    // SC = O(n)

    // tabulation (Space optimization)
    public static int minCostSpaceOptimization(int[] height) {
        int prev = 0;
        int prevTwo = 0;
        for(int i=1;i<height.length;i++){
            int oneStep = prev + Math.abs(height[i] - height[i-1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = prevTwo + Math.abs(height[i]-height[i-2]);
            }

            int curr = Math.min(oneStep, twoStep);

            prevTwo = prev;
            prev = curr;
        }
        return prev; 
    }
    // TC = O(n)
    // SC = O(1)

    public static void main(String[] args) {
        int[]  heights = {20, 30, 40, 20};
        System.out.println(minCost1(heights));
    }
}