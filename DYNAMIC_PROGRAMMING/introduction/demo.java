import java.util.*;

public class demo {
    public static int fibonacci(int n,int[] dp){ //memoization
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1) return dp[n];

        return dp[n] = fibonacci(n-1,dp) + fibonacci(n-2,dp);
    }
    // normal recursion:
    // TC = O(2^n)
    // SC = O(n){stack}

    // dynamic programming:
    // TC = O(n)
    // SC = O(n){stack} + O(n){array} ~ O(n)

    public static int approachTwo(int n,int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    // TC = O(n) {for loop}
    // SC = O(n) {array}

    public static int approachThree(int n){
        int prevTwo = 0;
        int prev = 1;

        for(int i=2;i<=n;i++){
            int currI = prev + prevTwo;

            prevTwo = prev;
            prev = currI;
        }
        return prev;
    }

    // TC = O(n)
    // SC = O(1)

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(approachThree(n));
    }

    
}
