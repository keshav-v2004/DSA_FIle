class Solution {
    public int compareBitonicSums(int[] nums) {
        
        int peakElement = Integer.MIN_VALUE;
        int peakIndex = -1;

        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            int elem = nums[i];

            if(elem > peakElement){
                peakElement = elem;
                peakIndex = i;
            }
        }

        long ascending = 0;
        for(int i = 0 ; i <= peakIndex ; i++){
            ascending += (long)nums[i];
        }

        long descending = 0;
        for(int i = peakIndex ; i < n ; i++){
            descending += (long)nums[i];
        }

        if(ascending > descending) return 0;

        else if(ascending == descending) return -1;

        return 1;

    }
}