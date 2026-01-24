class Solution {
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        int maxPairSum = 0;

        while (low < high) {
            int sum = nums[low] + nums[high];
            maxPairSum = Math.max(maxPairSum, sum);

            low++;
            high--;
        }

        return maxPairSum;
    }
}
