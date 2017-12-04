import java.util.*;


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String word: wordDict) {
                if (i - word.length() + 1 >= 0 && table[i - word.length() + 1] && s.substring(i - word.length() + 1, i + 1).equals(word)) {
                    table[i + 1] = true;
                    break;
                }
            }
        }
        return table[s.length()];
    }
}
