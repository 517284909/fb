import java.util.*;

class Solution {
  public List<String> removeInvalidParentheses(String s) {
    int n_left = 0, n_right = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        ++n_left;
      } else if (s.charAt(i) == ')') {
        if (n_left > 0) {
          --n_left;
        } else {
          ++n_right;
        }
      }
    }
    Set<String> results = new HashSet<>();
    removeInvalidParentheses(s, 0, 0, 0, n_left, n_right, new String(), results);
    return new ArrayList(results);
  }

  private void removeInvalidParentheses(String s, int idx, int n_left, int n_right, int r_left, int r_right, String current, Set<String> results) {
    if (idx == s.length()) {
      if (r_left == 0 && r_right == 0) {
        results.add(current);
      }
      return;
    }
    if (r_left < 0 || r_right < 0 || n_left < n_right) {
      return;
    }

    if (s.charAt(idx) == '(') {
      removeInvalidParentheses(s, idx + 1, n_left + 1, n_right, r_left, r_right, current + s.charAt(idx), results);
      removeInvalidParentheses(s, idx + 1, n_left, n_right, r_left - 1, r_right, current, results);
    } else if (s.charAt(idx) == ')') {
      removeInvalidParentheses(s, idx + 1, n_left, n_right + 1, r_left, r_right, current + s.charAt(idx), results);
      removeInvalidParentheses(s, idx + 1, n_left, n_right, r_left, r_right - 1, current, results);
    } else {
      removeInvalidParentheses(s, idx + 1, n_left, n_right, r_left, r_right, current + s.charAt(idx), results);
    }
  }

  // Return only one of longest valid parentheses
  public String removeInvalidParenthesesII(String s) {
    StringBuilder left = checkOneWay(s, '(', ')');
    StringBuilder right = checkOneWay(left.reverse().toString(), ')', '(');
    return right.reverse().toString();
  }

  private StringBuilder checkOneWay(String s, char left, char right) {
    // #left >= #right
    StringBuilder builder = new StringBuilder();
    int n_left = 0, n_right = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == left) {
        builder.append(s.charAt(i));
        ++n_left;
      } else if (s.charAt(i) == right) {
        if (n_left > 0) {
          --n_left;
          builder.append(s.charAt(i));
        }
      } else {
        builder.append(s.charAt(i));
      }
    }

    return builder;
  }

  public final static void main(String[] args) {
    Solution solution = new Solution();
    {
      System.out.println(solution.removeInvalidParentheses(""));
      System.out.println(solution.removeInvalidParentheses("(a)())()"));
      System.out.println(solution.removeInvalidParentheses("a(aa)())(a)a"));
      System.out.println(solution.removeInvalidParentheses(")("));
      System.out.println(solution.removeInvalidParentheses("()())()"));
    }

    System.out.println();
    {
      System.out.println(solution.removeInvalidParenthesesII(""));
      System.out.println(solution.removeInvalidParenthesesII("(a)())()"));
      System.out.println(solution.removeInvalidParenthesesII("a(aa)())(a)a"));
      System.out.println(solution.removeInvalidParenthesesII(")("));
      System.out.println(solution.removeInvalidParenthesesII("()())()"));
    }
  }
}

