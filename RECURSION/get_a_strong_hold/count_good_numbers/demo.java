public class demo {
    static long mod = 1000000007;
    public static long pow(int x , long n){
        if(n == 0){
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        long half = pow(x, n/2)%mod;
        if(n%2 == 0){
            return (half * half)%mod;
        }else{
            return (half * half * x)%mod;
        }
        
    }
    public static int countGoodNumbers(long n) {
        
        long evenIndexCount = (n+1)/2;
        long oddIndexCount = n/2;

        long ans = (pow(5, evenIndexCount)* pow(4, oddIndexCount))%mod; 
        return (int)ans;
    }
    public static void main(String[] args) {
        int n = 50;
        System.out.println(countGoodNumbers(n));
    }
}
