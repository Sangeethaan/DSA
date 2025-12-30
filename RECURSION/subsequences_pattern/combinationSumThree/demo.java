import java.util.*;

public class demo {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(ansList,list,n,k,1);

        return ansList;
    }
    public static void helper(List<List<Integer>> ansList,List<Integer> list,int number,int k,int start){
        if(list.size() == k && number == 0){
            ansList.add(new ArrayList<>(list));
            return;
        }
        if(list.size() > k){
            return;
        }

        for(int i=start;i<10;i++){
            list.add(i);
            if(number-i >= 0){
                helper(ansList, list, number-i, k, i+1);
            }
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int n = 1;
        int k=4;
        System.out.println(combinationSum3(k, n));
    }
}
