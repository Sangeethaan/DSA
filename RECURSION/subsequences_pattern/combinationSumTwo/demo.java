import java.util.*;

public class demo {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
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
        for(int i=n;i<candidates.length;i++){
            if(i>n && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target-candidates[i] >= 0){
                list.add(candidates[i]);
                helper(ansList, list, target-candidates[i], i+1, candidates);
                list.remove(list.size()-1);
            }
                
        }
        
    }

    public static void main(String args[]){
        int arr[] = {1,1,1,2,2};
        int target = 4;
        System.out.println(combinationSum2(arr, target));
    }
}
