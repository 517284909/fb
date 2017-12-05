import java.util.*;


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, visited, new ArrayList<Integer>(), results);
        return results;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                permute(nums, visited, current, results);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> results = solution.permute(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
