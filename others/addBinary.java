import java.util.*;

class Solution {
    /*We need to clarify if inputs start with 0*/
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int extra = 0;
        int a_pt = a.length() - 1, b_pt = b.length() - 1;
        while (a_pt >= 0 || b_pt >= 0) {
            if (a_pt >= 0) {
                extra += a.charAt(a_pt--) - '0';
            }
            if (b_pt >= 0) {
                extra += b.charAt(b_pt--) - '0';
            }
            result.append(extra % 2);
            extra /= 2;
        }
        if (extra > 0) {
            result.append(extra);
        }
        return result.reverse().toString();
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}
