class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        int n = nums.length;

        int answer = Integer.MIN_VALUE;

        long windowSum = 0;
        

        while(r < n){

            windowSum += nums[r];

            if(nums[r]==nums[l]){
                answer = Math.max(answer , r-l+1);
            }

            else{
                long cost = (long) nums[r] * (r - l + 1) - windowSum;
                if (cost > k) {
                    windowSum -= nums[l];
                    l++;
                } else {
                    answer = Math.max(answer, r - l + 1);
                }
            }
            r++;
        }
        return answer;

    }
}