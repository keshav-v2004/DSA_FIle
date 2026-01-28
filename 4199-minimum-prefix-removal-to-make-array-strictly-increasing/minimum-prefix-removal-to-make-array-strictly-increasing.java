class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;

        int index = -1;

        for(int i = n-1 ; i>= 1 ; i--){
            int last = nums[i];
            int secondLast = nums[i-1];

            if(secondLast >= last){
                index = i;
                break;
            }
        }
        if(index==-1) return 0;
        return index;
    }
}