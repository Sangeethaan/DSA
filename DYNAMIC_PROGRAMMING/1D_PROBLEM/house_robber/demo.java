import java.util.*;

class demo {
    // Recursion
    public int rob(int[] nums) {
        return helper(nums.length-1,nums);
    }

    public static int helper(int i,int[] nums){
        if(i == 0) return nums[i];
        if(i < 0) return 0;

        int rob = nums[i] + helper(i-2,nums);
        int dontRob = helper(i-1,nums);

        return Math.max(rob,dontRob);
    }
    // TC = O(2^n)
    // SC = O(n)

    // Memoization
    public static int robM(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helperM(nums.length-1,nums,dp);
    }

    public static int helperM(int i,int[] nums,int[] dp){
        if(i == 0) return nums[i];
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        int rob = nums[i] + helperM(i-2,nums,dp);
        int dontRob = helperM(i-1,nums,dp);

        return dp[i] = Math.max(rob,dontRob);
    }
    // TC = O(n)
    // SC = O(n)+O(n) ~ O(n)

    // Tabulation
    public static int robTabulation(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int rob = 0;
        int dontRob = 0;
        for(int i=1;i<nums.length;i++){
            if(i != 1){
                rob = nums[i] + dp[i-2];
            }else{
                rob = nums[i];
            }
            dontRob = dp[i-1];

            dp[i] = Math.max(rob, dontRob);
        }
        return dp[nums.length-1];

    }
    // TC = O(n)
    // SC = O(n) for loop

    // Space optimization
    public static int robSpaceOptimization(int[] nums) {

        int prev = nums[0];
        int prevTwo = 0;

        int rob = 0;
        int dontRob = 0;
        for(int i=1;i<nums.length;i++){
            if(i != 1){
                rob = nums[i] + prevTwo;
            }else{
                rob = nums[i];
            }
            dontRob = prev;

            int curr = Math.max(rob, dontRob);

            prevTwo = prev;
            prev = curr;
        }
        return prev;

    }
    // TC = O(n)
    // SC = O(1)

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(robSpaceOptimization(nums));
    }
}