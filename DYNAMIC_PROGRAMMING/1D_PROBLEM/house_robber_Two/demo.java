import java.util.*;

public class demo {
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int temp1[] = new int[nums.length-1]; // zero to n-1
        int temp2[] = new int[nums.length-1]; // 1 to n

        int ind1 = 0;
        int ind2 = 1;
        while (ind1 < nums.length-1) {
            temp1[ind1] = nums[ind1];
            ind1 ++;
        }
        
        while (ind2 < nums.length) {
            temp2[ind2 - 1] = nums[ind2];
            ind2 ++;
        }

        return Math.max(helper(temp1), helper(temp2)); 
    }
    public static int helper(int[] nums) {

        int prev = nums[0];
        int prevTwo = 0;

        int rob = 0;
        int dontRob = 0;
        for(int i=1;i<nums.length;i++){
            if(i != 1){
                rob = nums[i] + prevTwo;
            }else{
                rob = nums[i];
            }
            dontRob = prev;

            int curr = Math.max(rob, dontRob);

            prevTwo = prev;
            prev = curr;
        }
        return prev;

    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(rob(nums)); 

    }
}
