import java.util.*;

public class demo {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(ansList,list,target,0,candidates);

        return ansList;
    }

    public static void helper(List<List<Integer>> ansList,List<Integer> list,int target,int n,int[] candidates){
        if(target == 0){
            ansList.add(new ArrayList<>(list));
            return;
        }
        if(n == candidates.length){
            return;
        }
        list.add(candidates[n]);
        if(target-candidates[n] >= 0){
            helper(ansList, list, target-candidates[n], n, candidates);
        }
        list.remove(list.size()-1);
        helper(ansList, list, target, n+1, candidates);
    }

    public static void main(String args[]){
        int arr[] = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(arr, target));
    }
}
