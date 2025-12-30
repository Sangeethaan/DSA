import java.lang.reflect.Array;
import java.util.*;

public class demo {
    // using array
    public static void sortStackBrute1(Stack<Integer> st) {
        // code here
        int arr[] = new int[st.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = st.pop();
        }
        
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        // TC : O(n) + O(n logn) + O(n) = O(nlogn)
        // SC : O(n)
    }

    // using 2 stacks
    public static void sortStackBrute2(Stack<Integer> st) {
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();

        while (!st.isEmpty()) {
            int data = st.pop();

            if(temp1.isEmpty()){
                temp1.push(data);
            }else{
                while (!temp1.isEmpty() && temp1.peek() < data) {
                    temp2.push(temp1.pop());
                }
                temp1.push(data);
                while (!temp2.isEmpty()) {
                    temp1.push(temp2.pop());
                }
            }
        }
        while (!temp1.isEmpty()) {
            st.push(temp1.pop());
        }
        // TC = O(n^2) + O(n) = O(n^2)
        // SC = O(n) + O(n) = O(n)
    }

    public static void sortStackBetter(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            int data = st.pop();
            int count = 0;
            while (!temp.isEmpty() && temp.peek() < data) {
                st.push(temp.pop());
                count++;
            }
            temp.push(data);
            while (count > 0) {
                temp.push(st.pop());
                count--;
            }
        }
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        // TC = O(n^2)
        // SC = O(n)
    }

    // optimal solution
    public static void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()) return;

        int top = st.pop();
        sortStack(st);
        insertIntoSorted(st,top);
    }
    public static void insertIntoSorted(Stack<Integer> st,int element){
        if(st.isEmpty() || st.peek() <= element){
            st.push(element);
            return;
        }
        int top = st.pop();
        insertIntoSorted(st, element);
        st.push(top);
    }
    // TC = O(n^2);
    // SC = O(1) no extra space is used, but O(n) for recursive stack
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);
        sortStack(st);
        System.out.println(st);
    }
}
