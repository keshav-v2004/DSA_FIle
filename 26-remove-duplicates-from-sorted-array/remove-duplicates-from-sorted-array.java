class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;

        for(int i = 0 ; i < nums.length ; i++){

            int cur = nums[i];
            if(cur != nums[index]){
                nums[index+1] = cur;
                index++;
            }
        }
        return index+1;
    }
}