class Solution {
    public boolean check(int[] nums) {
        int x = 0;

        for(int i = 0 ; i < nums.length -1 ; i++){
            int first = nums[i];
            int second = nums[i+1];

            if(first > second){
                x++;
            }
        }
        if(x==0) return true;

        int last = nums[nums.length-1];
        int first = nums[0];

        if(last > first){
            x++;
        }

        return x <= 1;
    }
}