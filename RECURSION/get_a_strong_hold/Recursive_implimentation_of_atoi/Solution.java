class Solution {
    public static int myAtoi(String s) {
        int ans = 0;
        boolean isPositive = true;
        int ind = 0;
    
        while (ind < s.length() && s.charAt(ind) == ' ') {
            ind++;
        }
        if (ind < s.length() && (s.charAt(ind) == '+' || s.charAt(ind) == '-')) {
            isPositive = s.charAt(ind) == '+' ? true : false;
            ind++;
        }
        while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
            int digit = s.charAt(ind) - '0';

            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE/10 && digit > 7)){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans*10 + digit;
            ind++;
        }

        return isPositive ? ans : -ans;
    }

}

    // TC : O(n)
    // SC : O(1)

    // RECURSIVE APPROACH
    // public static int myAtoi(String s) {
    //     return helper(s, 0, 0, true);
    // }

    // private static int helper(String s, int ind, int ans, boolean isPositive) {
    //     ...
    // }