import java.util.*;


class BasicCalcultor {
    // + * ()
    public int calculateP(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ')') {
                stack.push(s.charAt(i));
            } else {
                StringBuilder builder = new StringBuilder();
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '(') break;
                    builder.append(top);
                }
                String result = Integer.toString(calculate(builder.reverse().toString()));
                for (int j = 0; j < result.length(); j++) {
                    stack.push(result.charAt(j));
                }
            }

            ++i;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return calculate(builder.reverse().toString());
    }

    // + * 
    public int calculate(String s) {
        return calculate(s, 0, s.length() - 1);
    }

    private int calculate(String s, int start, int end) {
        if (start > end) {
            return 0;
        }

        int i = start;
        while (i <= end) {
            if (s.charAt(i) == '+') {
                break;
            }
            ++i;
        }
        if (i > end) {
            return doCalculate(s.substring(start, end + 1));
        }
        return calculate(s, start, i - 1) + calculate(s, i + 1, end);
    }

    private int doCalculate(String s) {
        int result = 1, i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + s.charAt(i + 1) - '0';
                    ++i;
                }
                result *= num;
            }
            ++i;
        }
        return result;
    }

    public final static void main(String[] args) {
        BasicCalcultor calculator = new BasicCalcultor();
        System.out.println(calculator.calculateP("(1 * 3 + 76) * ( ( 10 +   11 ) * 7 + 8 ) + 9 "));
    }
}

