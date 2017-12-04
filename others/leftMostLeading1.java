import java.util.*;

class Solution {
    // O(n+m)
    public int leftMost(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int n = grid.length, m = grid[0].length;
        int i = 0, j = m - 1;
        while (i < n) {
            while (j > 0 && grid[i][j - 1] == 1) {
                --j;
            }
            ++i;
        }

        return j;
    }

    public final static void main(String[] args) {
        int[][] grid = {{0,0,0,1,1,1},
                        {0,0,1,1,1,1},
                        {0,0,0,0,0,1},
                        {0,1,1,1,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.leftMost(grid));
    }
}

