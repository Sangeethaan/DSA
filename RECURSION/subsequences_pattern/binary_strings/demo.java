import java.sql.Time;
import java.util.*;

public class demo {
    // variety 1 : generate all the possible binary string combination
    public static ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> arr = new ArrayList<>();
        generateBinary(n,"",arr);
        return arr;
        
    }

    public static void generateBinary(int n,String s,ArrayList<String> arr){
        if(s.length() == n){
            arr.add(s);
            return;
        }
        generateBinary(n, s+"0", arr);
        generateBinary(n, s+"1", arr);
    }
    // TC : O(2ⁿ)[number of recursion call] + O(n·2ⁿ)[string concatenation = O(length of s),max length of s = n, for each call string concatenation is done so O(n*2^n)] ≈ O(n·2ⁿ)
    // SC : O(n)[recursion stack] + O(n·2ⁿ)[size of arraylist , which stores 2^n elements each of size n] ~ O(n.2^n)

    public static int countStrings(int n) {
        List<String> list = new ArrayList<>();
        helper(n,list,"");
        System.out.println(list);
        return list.size();
    }
    public static void helper(int n,List<String> list,String s){
        if(n == 0){
            list.add(s);
            return;
        }
        helper(n-1, list, s+"0");
        if(s.length() == 0 || s.charAt(s.length()-1) != '1'){
            helper(n-1, list, s+"1");
        }
    }
// Time Complexity:
// O(n · F(n)) ≈ O(n · φⁿ)

// Space Complexity:
// O(n) auxiliary space + O(n · F(n)) output space
// ⇒ Overall O(n · φⁿ)
// Since not every recursion level branches into two calls,the recursion follows a Fibonacci pattern,giving φⁿ instead of 2ⁿ.

    public static void main(String[] args) {
        // System.out.println(binstr(3));
        System.out.println(countStrings(4));
    }
}
