import java.util.*;


class Solution {
    private boolean isLetterNumber(char ch) {
        return ch <= '9' && ch >= '0' || ch <= 'z' && ch >= 'a' || ch <= 'Z' && ch >= 'A';
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isLetterNumber(s.charAt(l))) {
                ++l;
            }
            while (r > l && !isLetterNumber(s.charAt(r))) {
                --r;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("..@#$"));
        System.out.println(solution.isPalindrome("..@a#$"));
        System.out.println(solution.isPalindrome(".b.@a#$b"));
        System.out.println(solution.isPalindrome(""));
        System.out.println(solution.isPalindrome(".b.@#$%c"));
    }
}


