import java.util.ArrayList;
import java.util.List;

public class demo {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        createParenthesis("",0,0,n,list);
        return list;
    }
    public static void createParenthesis(String s,int open, int close, int n,ArrayList<String> list){
        if(s.length() == n*2){
            list.add(s);
            return;
        }
        if(open < n){
            createParenthesis(s+"(", open+1, close, n, list);
        }
        if(close < open){
            createParenthesis(s+")", open, close+1, n, list);
        }
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
