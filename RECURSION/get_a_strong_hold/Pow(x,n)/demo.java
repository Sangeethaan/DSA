class demo {
    public static double myPowForPositiveN(double x, int n) {
        if(n == 1){
            return x;
        }
        if(n == 0){
            return 1;
        }
        double half = myPowForPositiveN(x, n/2);
        if(n % 2 == 0){
            return half * half;
        }else{
            return half* half *x;
        }
    }

    public static double myPow(double x, int n) {
        if(n < 0){
            return 1/myPowForPositiveN(x, -n);
        }else{
            return myPowForPositiveN(x, n);
        }
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    // TC = O(log₂ n) ~ O(logn)
    // SC = O(log₂ n) ~ O(logn) recursion stack space
}