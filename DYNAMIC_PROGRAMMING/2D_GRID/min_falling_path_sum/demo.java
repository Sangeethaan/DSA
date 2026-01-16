import java.util.*;

public class demo {
    public static int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        for(int col=0;col<matrix[0].length;col++){
            ans = Math.min(ans, helper(0, col, matrix));
        }
        return ans;
    }

    public static int helper(int row,int col,int[][] matrix){
        if(row == matrix.length){
            return 0;
        }
        int path1 = Integer.MAX_VALUE;
        if(col-1 >= 0){
            path1 = matrix[row][col] + helper(row+1, col-1, matrix);
        }

        int path2 = matrix[row][col] + helper(row+1, col, matrix);

        int path3 = Integer.MAX_VALUE;
        if(col+1 < matrix[0].length){
            path3 = matrix[row][col] + helper(row+1, col+1, matrix);
        }

        return Math.min(Math.min(path1, path2), path3);
    }

    // TC = 3^(n)
    // SC = O(n)

    public static int minFallingPathSumMemo(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        int ans = Integer.MAX_VALUE;
        for(int col=0;col<matrix[0].length;col++){
            ans = Math.min(ans, helper(0, col, matrix,dp));
        }
        return ans;
    }

    public static int helper(int row,int col,int[][] matrix,Integer[][] dp){
        if(row == matrix.length){
            return 0;
        }

        if(dp[row][col] != null) return dp[row][col];

        int path1 = Integer.MAX_VALUE;
        if(col-1 >= 0){
            path1 = matrix[row][col] + helper(row+1, col-1, matrix,dp);
        }

        int path2 = matrix[row][col] + helper(row+1, col, matrix,dp);

        int path3 = Integer.MAX_VALUE;
        if(col+1 < matrix[0].length){
            path3 = matrix[row][col] + helper(row+1, col+1, matrix,dp);
        }

        return dp[row][col] = Math.min(Math.min(path1, path2), path3);
    }
    // TC = O(n x m)
    // SC = O(n) + O(n x m)

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}
