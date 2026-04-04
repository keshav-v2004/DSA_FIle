class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        
        helper(nums , 0 );

        return answer;
    }

    public void helper(int[] nums , int index ){

        if(index == nums.length){
            
            List<Integer> perm = new ArrayList<>();

            for(int elem : nums){
                perm.add(elem);
            }

            if(!set.contains(perm)){
                answer.add(perm);
                set.add(perm);
            }
            return;
        }

        for(int i = index ; i < nums.length ; i++){

            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            helper(nums , index+1);
            
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;


        }


    }
}