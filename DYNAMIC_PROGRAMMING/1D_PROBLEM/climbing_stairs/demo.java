import java.util.*;

class demo {
    // recursion
    public static int climbStairs(int n) {
        if(n <= 0){
            return (n==0) ? 1 : 0;
        }
        return climbStairs(n-1) + climbStairs(n-2); 
    }
    // TC = O(2^n)
    // SC = O(n) recurion stack

    // Memoization
    public static int climbStairs1(int n,int[] dp) {
        if(n <= 0){
            return (n==0) ? 1 : 0;
        }
        if(dp[n] != -1) return dp[n];
        return dp[n] = climbStairs1(n-1,dp) + climbStairs1(n-2,dp);
    }
    // TC = O(n)
    // SC = O(n) recursion Stack + O(n) Array space ~ O(n)

    // Tabulation problem
    public int climbStairsTabulation(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    
    }
    // TC = O(n)
    // SC = O(n)

    // tabular (Space optimization)
    public int climbStairsSpaceOptimization(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        
        int prevTwo = 1;
        int prev = 2;
        
        for(int i=3;i<=n;i++){
            int currStep = prev + prevTwo;

            prevTwo = prev;
            prev = currStep;
        }
        
        return prev;
    
    }
    // TC = O(n)
    // SC = O(1)

    public static void main(String[] args) {
        int n = 3;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climbStairs1(n,dp));
        
    }
}