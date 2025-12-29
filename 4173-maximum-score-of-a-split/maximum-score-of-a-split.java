class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        
        int[] suffixMin = new int[n];

        long[] prefixSum = new long[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }


        suffixMin[n-1] = nums[n-1];
        suffixMin[n-2] = Math.min(nums[n-1] , nums[n-2]);

        for(int i = nums.length-3 ; i>= 0 ; i--){
            suffixMin[i] = Math.min(nums[i] , suffixMin[i+1]);
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, prefixSum[i] - suffixMin[i + 1]);
        }
        return max;
    }
}