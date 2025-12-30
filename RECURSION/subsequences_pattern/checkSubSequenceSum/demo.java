import java.util.*;

public class demo {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        return checkSubsequence(N, arr, K, 0);
    }
    public static boolean checkSubsequence(int n, int[] arr, int k,int sum) {
        // code here
        if(sum == k){
            return true;
        }
        if(n == arr.length){
            return false;
        }
        
        return checkSubsequence(n+1, arr, k, sum+arr[n]) || checkSubsequence(n+1, arr, k, sum);    
    }
    public static void main(String[] args) {
        int ans[] = {5, 1, 2, 7, 6, 1, 5};
        int k = 8;
        System.out.println(checkSubsequenceSum(ans.length, ans, k));
    }
}
