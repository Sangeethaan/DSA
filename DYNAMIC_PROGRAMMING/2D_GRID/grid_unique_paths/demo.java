import java.sql.Time;

class demo {
    public static int uniquePaths(int m, int n) {
        return helper(m-1,n-1);
    }
    public static int helper(int row,int col){
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;

        int up =  helper(row-1, col);
        int left = helper(row, col-1);

        return up+left;
    }
    // TC = O(2^(m+n))
    // SC = O((m-1)+(n-1))

    // Memoization
    public static int uniquePathsMemo(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(m-1,n-1,dp);
    }
    public static int helper(int row,int col,int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;

        if(dp[row][col] != -1) return dp[row][col];

        int up =  helper(row-1, col,dp);
        int left = helper(row, col-1,dp);

        return dp[row][col] = up+left;
    }
    // Time Complexity:
    // There are m * n unique states (row, col) in dp.
    // Each state is computed once because of memoization.
    //  O(m × n)

    // Space Complexity:
    // DP array: m × n → O(m × n)
    // Recursion stack: max depth is (m-1 + n-1) → O(m + n)

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePathsMemo(m,n));
    }
}