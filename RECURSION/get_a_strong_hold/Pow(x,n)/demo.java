
public class demo {
    public static double bruteForce(double x, int n) {
        
        long N = n;
        boolean isPositive = (N >= 0) ? true : false;
        double ans = 1;
        N = Math.abs(N);

        while (N > 0) {
            ans *= x;
            N--;
        }

        return isPositive ? ans : 1/ans;

        // TC : O(n)
        // SC : O(1)
    }

    public static double myPow(double x, int n) {
        if(n == 1){
            return x;
        }
        if(n % 2 == 0){
            return myPow(x, n/2)*myPow(x, n/2);
        }else{
            return myPow(x, n/2)*myPow(x, n/2)*myPow(x, 1);
        }
    }

    

    public static void main(String[] args) {
        double x = 2;
        int n = 5;
        System.out.println(myPow(x, n));
    }
}
