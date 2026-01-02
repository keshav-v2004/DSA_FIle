class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> each = new ArrayList<>();

        Map<Integer , Boolean> map = new HashMap<>();
        for(int elem : nums){
            map.put(elem , false);
        }


        helper(each , map ,nums , answer);
        return answer;
    }

    public void helper(List<Integer> each , Map<Integer , Boolean> map , int[] nums , List<List<Integer>> answer){
        boolean found = false;

        for(int i = 0 ; i< nums.length ; i++){
            if(map.get(nums[i])==false){
                found = true;
                each.add(nums[i]);
                map.put(nums[i] , true);

                helper(each , map , nums , answer);
                each.remove(each.size()-1);
                map.put(nums[i] , false);
            }
        }
        
        if(found==false){
            answer.add(new ArrayList<>(each));
            return;
        }
    }
}