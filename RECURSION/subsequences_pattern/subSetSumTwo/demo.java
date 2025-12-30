import java.util.*;

public class demo {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,list,ansList);
        return ansList;
    }
    public static void helper(int[] nums,int n,List<Integer> list, List<List<Integer>> ansList){
        if(n == nums.length){
            ansList.add(new ArrayList<>(list));
            return;
        }else{
            ansList.add(new ArrayList<>(list));
        }
        for(int i=n;i<nums.length;i++){
            if( i > n && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            helper(nums, i+1, list, ansList);
            list.remove(list.size()-1);
        }

    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        System.out.println(subsetsWithDup(arr));
    }
}
