import java.util.*;

public class demo {
    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here
        return countSubSequences(nums,k,0,0);
    }
    public static int countSubSequences(int[] nums,int k,int sum,int n){
        if(sum == k){
            return 1;
        }
        if(sum > k || n == nums.length){
            return 0;
        }

        return countSubSequences(nums, k, sum+nums[n], n+1) + countSubSequences(nums, k, sum, n+1);
    }
    public static void main(String[] args) {
        int nums[] = {4, 2, 10, 5, 1, 3};
        int k=5;
        System.out.println(countSubsequenceWithTargetSum(nums, k));
    }
}
