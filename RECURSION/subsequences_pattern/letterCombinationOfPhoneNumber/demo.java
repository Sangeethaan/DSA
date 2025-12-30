import java.util.*;

public class demo {
    public static List<String> letterCombinations(String digits) {
        String[] map = new String[10];
        map[2] ="abc";
        map[3] ="def";
        map[4] ="ghi";
        map[5] ="jkl";
        map[6] ="mno";
        map[7] ="pqrs";
        map[8] ="tuv";
        map[9] ="wxyz";

        List<String> list = new ArrayList<>();
        helper(digits,list,0,map,"");
        return list;
    }

    public static void helper(String digits,List<String> list,int n,String[] map,String ans){

        if(n == digits.length()){
            list.add(ans);
            return;
        }

        int digit = digits.charAt(n)-'0';
        for(int i=0;i<map[digit].length();i++){
            String ch = map[digit].charAt(i)+"";
            helper(digits, list, n+1, map,ans+ch);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
