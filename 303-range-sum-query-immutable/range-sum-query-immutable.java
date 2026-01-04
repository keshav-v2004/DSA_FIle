class NumArray {
    public int[] prefix;

    public NumArray(int[] nums) {

        prefix = new int[nums.length+1];
        

        for(int i  = 0  ; i < nums.length ; i++){
            prefix[i + 1] = nums[i] + prefix[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = prefix[right+1] - prefix[left];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */