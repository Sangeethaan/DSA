import java.util.*;

public class demo {
    public static int minimumTotal(List<List<Integer>> triangle) {
        return helper(0,0,triangle);
    }

    public static int helper(int row,int col,List<List<Integer>> triangle){
        if(row == triangle.size()){
            return 0;
        }
        int path1 = triangle.get(row).get(col) + helper(row+1, col, triangle);
        int path2 = triangle.get(row).get(col) + helper(row+1, col+1, triangle);

        return Math.min(path1, path2);
    }

    // TC = O(2^(1+2+3+....+n)){where n is number of rows}
    // SC = O(n){recursion stack space}


    public static int minimumTotalMemo(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];


        return helper(0,0,triangle,dp);
    }

    public static int helper(int row,int col,List<List<Integer>> triangle,Integer[][] dp){
        if(row == triangle.size()){
            return 0;
        }
        if (dp[row][col] != null) return dp[row][col];
        int path1 = triangle.get(row).get(col) + helper(row+1, col, triangle,dp);
        int path2 = triangle.get(row).get(col) + helper(row+1, col+1, triangle,dp);

        return dp[row][col] = Math.min(path1, path2);
    }

    // Time Complexity = (# of states) × (work per state)
    // here the states are row(0...n) and col(0...n)
    // work per state is O(1)
    // TC = O(n x n) * O(1) ~ O(n^2)

    // Space complexity = O(n){recursion stack space} + O(n x n){dp array}



    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }
}
