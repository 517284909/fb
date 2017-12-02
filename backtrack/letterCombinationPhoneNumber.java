import java.util.*;

class Solution {
    private String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        letterCombinations(digits, 0, new StringBuilder(), results);        
        return results;
    }

    private void letterCombinations(String digits, int idx, StringBuilder current, List<String> results) {
        if (idx == digits.length()) {
            results.add(current.toString());
            return;
        }
        String key = keyboard[digits.charAt(idx) - '0'];
        if (key.length() == 0) {
            letterCombinations(digits, idx + 1, current, results);
        } else {
            for (int i = 0; i < key.length(); i++) {
                current.append(key.charAt(i));
                letterCombinations(digits, idx + 1, current, results);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        List<String> results = solution.letterCombinations("23");
        for (String str: results) {
            System.out.println(str);
        }
    }
}

