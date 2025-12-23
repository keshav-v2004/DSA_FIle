class Solution {
    public int absDifference(int[] nums, int k) {

        int n = nums.length;
        Integer[] arr = new Integer[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < k ; i++){
            x+=arr[i];
        }
        Arrays.sort(arr , Collections.reverseOrder());
        for(int i = 0 ; i < k ; i++){
            y+=arr[i];
        }
        return Math.abs(x-y);
    }
}