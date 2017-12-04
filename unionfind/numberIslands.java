import java.util.*;

class UnionFind {
    private int[] fathers;
    private int count;

    public UnionFind(int n) {
        fathers = new int[n];
        for (int i = 0; i < n; i++)
            fathers[i] = i;
    }

    public int find(int x) {
        if (fathers[x] == x) {
            return x;
        }

        return fathers[x] = find(fathers[x]);
    }

    public int union(int x, int y) {
        int p_x = find(x);
        int p_y = find(y);
        if (p_x != p_y) {
            fathers[p_x] = p_y;
            --count;
        }
        return count;
    }

    public void addIsland() {
        ++count;
        return;
    }

    public int getCount() {
        return count;
    }
}

class Solution {
    private UnionFind uf;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        uf = new UnionFind(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0')
                    continue;
                uf.addIsland();
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(i * m + j, (i - 1) * m + j);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(i * m + j, i * m + j - 1);
                }
            }
        }
        return uf.getCount();
    }
}
