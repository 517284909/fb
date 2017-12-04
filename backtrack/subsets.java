import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        subsets(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void subsets(int[] nums, int idx, List<Integer> current,
                         List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(current));
        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            subsets(nums, i + 1, current, results);
            current.remove(current.size() - 1);
        }
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        {
            List<List<Integer>> results = solution.subsets(new int[]{1});
            for (int i = 0; i < results.size(); i++) {
                for (int j = 0; j < results.get(i).size(); j++) {
                    System.out.print(results.get(i).get(j));
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        {
            List<List<Integer>> results = solution.subsets(new int[]{1, 2, 3});
            for (int i = 0; i < results.size(); i++) {
                for (int j = 0; j < results.get(i).size(); j++) {
                    System.out.print(results.get(i).get(j));
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}

