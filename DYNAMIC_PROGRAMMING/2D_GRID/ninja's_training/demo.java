import java.util.*;

class demo {

    // Recursion
    public static int maximumPoints(int arr[][]) {
        return helper(arr,arr.length-1,-1);
    }

    public static int helper(int[][] arr,int n,int prevCol){
        if(n == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i != prevCol){
                    max = Math.max(max, arr[n][i]);
                }
            }
            return max;
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<3;i++){
            if(i != prevCol){
                max = Math.max(max, arr[n][i] + helper(arr, n-1, i));
            }
        }
        return max;
    }
    // TC = O(2^n)
    // SC = O(n){stack space}

    // Memoization
    public static int maximumPointsMemo(int arr[][]) {
        int[][] dp = new int[arr.length][4];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(arr,arr.length-1,3,dp);
    }

    public static int helper(int[][] arr,int n,int prevCol,int[][] dp){
        if(n == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i != prevCol){
                    max = Math.max(max, arr[n][i]);
                }
            }
            return dp[n][prevCol] = max;
        }

        if(dp[n][prevCol] != -1) return dp[n][prevCol];

        int max = Integer.MIN_VALUE;

        for(int i=0;i<3;i++){
            if(i != prevCol){
                max = Math.max(max, arr[n][i] + helper(arr, n-1, i,dp));
            }
        }
        return dp[n][prevCol] = max;
    }
    // time complexity
    // Total work
    // = (number of states) × (work per state)
    // = (N x 4) × 3
    // = 12N ~ O(n)

    // Space Complexity
    // O(4 x N){dp array} +O(n) {stack space}

    public static int maximumPointsTab(int arr[][]) {
    int[][] dp = new int[arr.length][4];

    int n = arr.length;

    // Base case (day 0)
    dp[0][0] = Math.max(arr[0][1], arr[0][2]);
    dp[0][1] = Math.max(arr[0][0], arr[0][2]);
    dp[0][2] = Math.max(arr[0][0], arr[0][1]);
    dp[0][3] = Math.max(arr[0][0],
                 Math.max(arr[0][1], arr[0][2]));

    // Fill DP table
    for(int i = 1; i < n; i++){
        for(int prevCol = 0; prevCol < 4; prevCol++){
            int max = Integer.MIN_VALUE;

            for(int j = 0; j < 3; j++){
                if(j != prevCol){
                    max = Math.max(max, arr[i][j] + dp[i-1][j]);
                }
            }
            dp[i][prevCol] = max;
        }
    }

    return dp[n-1][3];
}

    
    public static void main(String[] args) {
        int arr[][] = {
            {1,2,5},
            {3,1,1},
            {3,3,3}
        };
        System.out.println(maximumPointsTab(arr));
    }
}