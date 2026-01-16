public class demo {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 == 0){
            int sumByTwo =totalSum/2;
            return helper(nums.length-1,sumByTwo,nums);
        }else{
            return false;
        }
        
    }

    public static boolean helper(int i,int target,int[] arr){
        if(target == 0) return true;
        if(i == 0) return (arr[0] == target) ? true : false;

        Boolean notTake = helper(i-1, target, arr);
        Boolean take = false;
        if(target >= arr[i]){
            take = helper(i-1, target-arr[i], arr);
        }

        return take || notTake;
    }
    // TC = O(2^n)
    // SC = O(n)

    public static boolean canPartitionMemo(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 == 0){
            int sumByTwo =totalSum/2;
            int[][] dp = new int[nums.length][sumByTwo+1];

            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j] = -1;
                }
            }

            return helper(nums.length-1,sumByTwo,nums,dp);
        }else{
            return false;
        }
        
    }

    public static boolean helper(int i,int target,int[] arr,int[][] dp){
        if(target == 0) return true;
        if(i == 0) return (arr[0] == target) ? true : false;

        if(dp[i][target] != -1) {
            return dp[i][target] == 1 ? true : false;
        };

        Boolean notTake = helper(i-1, target, arr,dp);
        Boolean take = false;
        if(target >= arr[i]){
            take = helper(i-1, target-arr[i], arr,dp);
        }

        Boolean ans =  take || notTake;
        dp[i][target] = (ans == true) ? 1 : 0;
        return ans;
    }

    // TC = O(n x target)
    // SC = O(n x target) {dp array} + O(n){recursion stack space}

    public static void main(String[] args) {
        int arr[] = {1,5,11,5};
        System.out.println(canPartition(arr));
    }
}
