import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;

        int l = 0;
        int r = k - 1;

        while (r < n) {
            diff = Math.min(diff, nums[r] - nums[l]);
            l++;
            r++;
        }

        return diff;
    }
}
