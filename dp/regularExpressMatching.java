import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length(); j += 2) {
            if (p.charAt(j) != '*') break;
            dp[0][j + 1] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*'){
                    if (j >= 1 && dp[i + 1][j - 1]) {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else if (j >= 1 && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("", "a*b*"));
        System.out.println(solution.isMatch("aabbb", "a*b*"));
        System.out.println(solution.isMatch("bbb", "a*b*"));
        System.out.println(solution.isMatch("bbb", ".*b*"));
    }
}

