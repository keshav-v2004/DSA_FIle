class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        boolean found = false;
        for(int i = n-2 ; i>= 0 ; i--){

            if(nums[i] < nums[i+1]){
                index = i;
                found=true;
                for (int j = n - 1; j > index; j--) {
                    if (nums[j] > nums[index]) {
                        int temp = nums[index];
                        nums[index] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                break;
            }
        }
        if(found==false){
            int start = 0;
            int end = n-1;
            while(start<= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }
        else{
            int start = index+1;
            int end = n-1;
            while(start<= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}