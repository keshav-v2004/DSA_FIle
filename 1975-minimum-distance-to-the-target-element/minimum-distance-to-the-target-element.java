class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int minDistance = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == target){
                minDistance = Math.min(
                    minDistance , Math.abs(start - i)
                );
            }
        }
        return minDistance;
        
    }
}