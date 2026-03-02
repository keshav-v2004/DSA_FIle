class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;

        for(int elem : nums){
            if(elem==0) zeroCount++;

        }
        int index = 0;

        for(int i = 0 ; i < nums.length ; i++){
            int elem = nums[i];

            if(elem != 0){
                nums[index] = elem;
                index++;
            }
        }
        while(zeroCount > 0){
            nums[index] = 0;
            zeroCount--;
            index++;
        }
    }
}