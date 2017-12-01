import java.util.*;

class Solution {
  public void moveZeroesFrom1Sides(int[] nums) {
    int left = -1, run = 0;
    while (run < nums.length) {
      if (nums[run] != 0) {
        int tmp = nums[run];
        nums[run] = 0;
        nums[++left] = tmp;
      }
      ++run;
    }
  }

  public void moveZeroesFrom2Sides(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      while (left < right && nums[left] != 0) {
        ++left;
      }
      while (right > left && nums[right] == 0) {
        --right;
      }
      nums[left] = nums[right];
      nums[right] = 0;
      ++left;
      --right;
    }
  }

  public final static void main(String[] args) {
    Solution solution = new Solution();
    {
      int[] nums1 = {1, 0};
      solution.moveZeroesFrom1Sides(nums1);
      System.out.println(Arrays.toString(nums1));
      int[] nums2 = {0, 1};
      solution.moveZeroesFrom1Sides(nums2);
      System.out.println(Arrays.toString(nums2));
      int[] nums3 = {0};
      solution.moveZeroesFrom1Sides(nums3);
      System.out.println(Arrays.toString(nums3));
      int[] nums4 = {1};
      solution.moveZeroesFrom1Sides(nums4);
      System.out.println(Arrays.toString(nums4));
      int[] nums5 = {1, 0, 9, 2, 2, 0, 2, 0, 1, 0, 0, 0, 0};
      solution.moveZeroesFrom1Sides(nums5);
      System.out.println(Arrays.toString(nums5));
    }
    {
      int[] nums1 = {1, 0};
      solution.moveZeroesFrom2Sides(nums1);
      System.out.println(Arrays.toString(nums1));
      int[] nums2 = {0, 1};
      solution.moveZeroesFrom2Sides(nums2);
      System.out.println(Arrays.toString(nums2));
      int[] nums3 = {0};
      solution.moveZeroesFrom2Sides(nums3);
      System.out.println(Arrays.toString(nums3));
      int[] nums4 = {1};
      solution.moveZeroesFrom2Sides(nums4);
      System.out.println(Arrays.toString(nums4));
      int[] nums5 = {1, 0, 9, 2, 2, 0, 2, 0, 1, 0, 0, 0, 0};
      solution.moveZeroesFrom2Sides(nums5);
      System.out.println(Arrays.toString(nums5));
    }
  }
}
