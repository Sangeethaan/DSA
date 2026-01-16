class demo{
    public static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return helper(arr.length-1,sum,arr);
    }

    public static Boolean helper(int ind,int sum,int[] arr){
        if(sum == 0) return true;
        if(ind == 0){
            return (arr[ind] == sum) ? true : false;
        }

        Boolean notTake = helper(ind-1, sum, arr);
        Boolean take = false;
        if(sum >= arr[ind]){
            take = helper(ind-1, sum-arr[ind], arr);
        }

        return take || notTake;
    }

    // TC = O(2 ^ n)
    // SC = O(n)

    public static Boolean isSubsetSumMemo(int arr[], int sum) {
        // code here
        int[][] dp = new int[arr.length][sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(arr.length-1,sum,arr,dp);
    }

    public static Boolean helper(int ind,int sum,int[] arr,int[][] dp){
        if(sum == 0) return true;
        if(ind == 0){
            return (arr[ind] == sum) ? true : false;
        }

        if(dp[ind][sum] != -1) {
            return dp[ind][sum] == 1 ? true : false;
        };

        Boolean notTake = helper(ind-1, sum, arr,dp);
        Boolean take = false;
        if(sum >= arr[ind]){
            take = helper(ind-1, sum-arr[ind], arr,dp);
        }

        Boolean ans =  take || notTake;
        dp[ind][sum] = (ans == true) ? 1 : 0;
        return ans;
    }
    // TC = O(n)
    // SC = O(n) {recursion stack}
    

    public static void main(String args[]){
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 30;
        System.out.println(isSubsetSum(arr, sum));
    }
}