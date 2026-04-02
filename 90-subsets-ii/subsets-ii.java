class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        helper(0,nums,new ArrayList<>());

        return answer;
    }

    public void helper(int index , int[] nums , List<Integer> each){

        if(index == nums.length){
            if(!set.contains(each)){
                answer.add(new ArrayList<>(each));
                set.add(each);    
            }
            return;
        }
        
        // pick this
        each.add(nums[index]);
        helper(index+1 , nums , each);
        each.remove(each.size()-1);


        // leave this
        helper(index+1 , nums ,each);

    }
}