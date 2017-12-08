import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) != '*') break;
            dp[0][j + 1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?');
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

