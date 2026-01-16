public class demo {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return helper(m-1, n-1,obstacleGrid);
        
    }

    public static int helper(int row,int col,int[][] obstacleGrid){
        if(row < 0 || col < 0) return 0;
        if(obstacleGrid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;

        int up =  helper(row-1, col,obstacleGrid);
        int left = helper(row, col-1,obstacleGrid);

        return up+left;
    }
    // TC = O(2^(m+n))
    // SC = O((m-1)+(n-1))

    public static int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return helper(m-1, n-1,obstacleGrid,dp);
        
    }
    // TC = O(m*n)
    // SC = O((m-1)+(n-1)) + O(m*n){dp}

    public static int helper(int row,int col,int[][] obstacleGrid,int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(obstacleGrid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;

        if(dp[row][col] != -1) return dp[row][col];

        int up =  helper(row-1, col,obstacleGrid,dp);
        int left = helper(row, col-1,obstacleGrid,dp);

        return dp[row][col] = up+left;
    }
    public static void main(String[] args) {
        int arr[][] = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
