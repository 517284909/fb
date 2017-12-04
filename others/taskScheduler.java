import java.util.*;

class Solution {

    // break order
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        int max_cnt = 0;
        for (char t: tasks) {
            ++table[t - 'A'];
            max_cnt = Math.max(max_cnt, table[t - 'A']);
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (table[i] == max_cnt) {
                ++cnt;
            }
        }

        return Math.max(tasks.length, (max_cnt - 1) * (n + 1) + cnt);
    }

    // keep order
    public int leastIntervalOrder(char[] tasks, int n) {
        int[] table = new int[26];
        int time = 1;
        for (int i = 0; i < tasks.length; i++) {
            int j = tasks[i] - 'A';
            if (table[j] == 0) {
                table[j] = time;
            } else {
                if (table[j] + n + 1 > time) {
                    time = table[j] + n + 1;
                }
                table[j] = time;
            }
            ++time;
        }
        return time - 1;
    }

    // keep order and print path
    public String leastIntervalPathOrder(char[] tasks, int n) {
        StringBuilder builder = new StringBuilder();
        int[] table = new int[26];
        int time = 1;
        for (int i = 0; i < tasks.length; i++) {
            int j = tasks[i] - 'A';
            if (table[j] == 0) {
                table[j] = time;
                if (builder.length() > 0)
                    builder.append("->");
                builder.append(tasks[i]);
            } else {
                while (time < table[j] + n + 1) {
                    builder.append("->").append("#");
                    ++time;
                }
                builder.append("->").append(tasks[i]);
                table[j] = time;
            }
            ++time;
        }
        return builder.toString();
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C'};
        System.out.println(solution.leastIntervalPathOrder(tasks, 2));
    }
}

