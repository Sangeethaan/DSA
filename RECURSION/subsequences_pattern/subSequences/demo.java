import java.util.*;

public class demo {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        generateSubsets(ansList,list,0,nums);
        return ansList;
    }
    public static void generateSubsets(List<List<Integer>> ansList,ArrayList<Integer> list,int n,int[] nums){
        if(n == nums.length){
            ansList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[n]);
        generateSubsets(ansList, list, n+1, nums);

        list.remove(list.size()-1);
        generateSubsets(ansList, list, n+1, nums);

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(subsets(arr));
    }
}
