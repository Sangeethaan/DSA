import java.util.*;

public class demo {
    public static ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        helper(arr,0,0,list);
        return list;
        
    }
    public static void helper(int[] arr,int n,int sum,ArrayList<Integer> list){
        if(n == arr.length){
            list.add(sum);
            return;
        }

        helper(arr,n+1,sum+arr[n],list);
        helper(arr,n+1,sum,list);
    }
    public static void main(String args[]){
        int arr[] = {1,2,2};
        System.out.println(subsetSums(arr));
    }
}
