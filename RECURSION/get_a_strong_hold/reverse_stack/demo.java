package get_a_strong_hold.reverse_stack;
import java.util.*;

import javax.management.Query;

public class demo {
    public static void reverseStackBrute(Stack<Integer> st) {
        // code here
        Queue<Integer> queue = new LinkedList<>();
        while (!st.isEmpty()) {
            queue.add(st.pop());
        }
        while (!queue.isEmpty()) {
            st.push(queue.poll());
        }
        // TC = O(n) + O(n) = O(n)
        // SC = O(n) for extra queue
    }
    
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseStack(st);
        placeAtBottom(st,top);
    }
    public static void placeAtBottom(Stack<Integer> st, int element){
        if (st.isEmpty()) {
            st.push(element);
            return;
        }
        int top = st.pop();
        placeAtBottom(st, element);
        st.push(top);
    }
    // TC = O(n^2)
    // SC = O(1)
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
}
