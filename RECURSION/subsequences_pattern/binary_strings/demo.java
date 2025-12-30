package subsequences_pattern.binary_strings;
import java.util.*;

public class demo {
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
    public static void main(String[] args) {
        System.out.println(binstr(3));
    }
}
