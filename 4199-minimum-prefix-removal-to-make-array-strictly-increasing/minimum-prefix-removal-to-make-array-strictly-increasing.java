class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;

        int[] pref = new int[n-1];

        for(int i = 0 ; i < n-1 ; i++){
            pref[i] = Math.min(nums[i] , nums[i+ 1]);
        }

        int pivot = -1;

        for(int i = n-1 ; i>= 1 ; i--){
            int index = i-1;

            if(nums[i] <= pref[index]){
                pivot = i;
                break;
            }
        }
        if(pivot==-1) return 0;
        return pivot;
    }
}