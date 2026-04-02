class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(0, nums);
        return answer;
    }

    public void helper(int index , int[] nums ){

        if(index == nums.length){
            ArrayList<Integer> each = new ArrayList<>();
            for(int elem : nums){
                each.add(elem);
            }
            answer.add(each);
            return;
        }

        for(int i = index ; i < nums.length ; i++){

            // swap index and i
            swap(nums, index, i);

            helper(index + 1, nums);

            // backtrack
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}