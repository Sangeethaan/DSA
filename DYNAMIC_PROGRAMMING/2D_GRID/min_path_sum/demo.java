public class demo {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return helper(m-1,n-1,grid);
    }
    public static int helper(int row,int col,int[][] grid){
        if(row == 0 && col == 0) return grid[0][0];

        int up = Integer.MAX_VALUE;
        if(row > 0){
            up = grid[row][col] + helper(row-1, col, grid);
        }

        int left = Integer.MAX_VALUE;
        if(col > 0){
            left = grid[row][col] + helper(row, col-1, grid);
        }

        return Math.min(up, left);
    }

    // TC = O(2^(m+n))
    // SC = O(m + n)

    public static int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return helper(m-1,n-1,grid,dp);
    }
    public static int helper(int row,int col,int[][] grid,int[][] dp){
        if(row == 0 && col == 0) return grid[0][0];

        if(dp[row][col] != -1) return dp[row][col];

        int up = Integer.MAX_VALUE;
        if(row > 0){
            up = grid[row][col] + helper(row-1, col, grid);
        }

        int left = Integer.MAX_VALUE;
        if(col > 0){
            left = grid[row][col] + helper(row, col-1, grid);
        }

        return dp[row][col] = Math.min(up, left);
    }

    // TC = O(m*n)
    // SC = O(m+n){recursion space} + O(m*n){dp array} ~ O(m*n)

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6}
        };
        System.out.println(minPathSum(arr));
    }
}
