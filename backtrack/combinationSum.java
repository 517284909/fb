import java.util.*;

class Solution {
  // no duplicated number and all are positive in candidates
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> results = new ArrayList<>();
    combinationSum(candidates, 0, target, 0, new ArrayList<Integer>(), results);
    return results;
  }

  private void combinationSum(int[] candidates, int idx, int target, int sum,
                              List<Integer> current, List<List<Integer>> results) {
    if (sum == target) {
      results.add(new ArrayList<Integer>(current));
      return;
    }
    if (sum > target || idx == candidates.length) {
      return;
    }

    for (int i = idx; i < candidates.length; i++) {
      current.add(candidates[i]);
      combinationSum(candidates, i + 1, target, sum + candidates[i], current, results);
      current.remove(current.size() - 1);
    }
  }

  public List<List<Integer>> combinationSumII(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> results = new ArrayList<>();
    combinationSumII(candidates, 0, target, 0, new ArrayList<Integer>(), results);
    return results;
  }

  private void combinationSumII(int[] candidates, int idx, int target, int sum,
                                List<Integer> current, List<List<Integer>> results) {
    if (sum == target) {
      results.add(new ArrayList<Integer>(current));
      return;
    }
    if (sum > target || idx == candidates.length) {
      return;
    }

    for (int i = idx; i < candidates.length; i++) {
      if (i > idx && candidates[i] == candidates[i - 1]) {
        continue;
      }
      current.add(candidates[i]);
      combinationSumII(candidates, i + 1, target, sum + candidates[i], current, results);
      current.remove(current.size() - 1);
    }
  }

  public List<List<Integer>> combinationSumIII(int k, int n) {
    List<List<Integer>> results = new ArrayList<>();
    combinationSumIII(k, n, 0, 0, new ArrayList<Integer>(), results);
    return results;
  }

  private void combinationSumIII(int k, int n, int sum, int t, List<Integer> current, List<List<Integer>> results) {
    if (sum == n) {
      if (current.size() == k) {
        results.add(new ArrayList<Integer>(current));
      }
      return;
    }
    if (sum > n || t > 9) {
      return;
    }
    for (int i = t; i <= 9; i++) {
      current.add(i);
      combinationSumIII(k, n, sum + i, i + 1, current, results);
      current.remove(current.size() - 1);
    }
  }


  private int cnt;
  public int combinationSumIV(int[] candidates, int target) {
    cnt = 0;
    combinationSumIV(candidates, target, 0);
    return cnt;
  }

  private void combinationSumIV(int[] candidates, int target, int sum) {
    if (sum == target) {
      ++cnt;
      return;
    }
    if (sum > target) {
      return;
    }

    for (int i = 0; i < candidates.length; i++) {
      combinationSumIV(candidates, target, sum + candidates[i]);
    }
  }

  public int combinationSumIV2(int[] nums, int target) {
    int table[] = new int[target + 1];
    table[0] = 1;

    for (int t = 1; t <= target; t++) {
      for (int i = 0; i < nums.length; i++) {
        if (t >= nums[i]) {
          table[t] += table[t - nums[i]];
        }
      }
    }
    return table[target];
  }

  public final static void main(String[] args) {
    Solution solution = new Solution();
    {
      int[] candidates1 = {4, 2, 6, 1, 10, 100, 3};
      List<List<Integer>> results1 = solution.combinationSum(candidates1, 8);
      for (int i = 0; i < results1.size(); i++) {
        for (int j = 0; j < results1.get(i).size(); j++) {
          System.out.print(results1.get(i).get(j));
          System.out.print(" ");
        }
        System.out.println();
      }
    }
    {
      int[] candidates1 = {4, 2, 6, 1, 10, 100, 3, 1, 3, 2};
      List<List<Integer>> results1 = solution.combinationSumII(candidates1, 8);
      for (int i = 0; i < results1.size(); i++) {
        for (int j = 0; j < results1.get(i).size(); j++) {
          System.out.print(results1.get(i).get(j));
          System.out.print(" ");
        }
        System.out.println();
      }
    }
    {
      int[] candidates1 = {1, 2, 3};
      int cnt = solution.combinationSumIV(candidates1, 32);
      System.out.println(cnt);
    }
  }
}
