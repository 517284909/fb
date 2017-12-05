import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        --m;
        --n;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[p--] = nums1[m--];
            } else {
                nums1[p--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();

        {
            int[] nums1 = new int[]{1, 3, 7, 4, 5};
            int[] nums2 = new int[]{2, 5};
            solution.merge(nums1, 3, nums2, 2);
            System.out.println(nums1);
        }
    }
}
