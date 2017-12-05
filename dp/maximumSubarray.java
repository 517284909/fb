import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, last = 0;
        for (int i = 0; i < nums.length; i++) {
            last = last > 0 ? last + nums[i] : nums[i];
            max = Math.max(max, last);
        }
        return max;
    }

    public static final void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{1, -3, -4}));
        System.out.println(solution.maxSubArray(new int[]{-3, 1}));
    }
}
