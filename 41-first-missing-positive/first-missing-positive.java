class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int elem : nums){
            set.add(elem);

        }
        int possible  = 1;
        while(set.contains(possible)){
            possible++;
        }
        return possible;
    }
}