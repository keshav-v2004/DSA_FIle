class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] hash = new int[nums.length+1];

        for(int i = 0 ; i < nums.length ; i++){
            hash[nums[i]]++;
        }

        int[] answer = new int[2];

        for(int i = 0 ; i < hash.length ; i++){
            if(hash[i]==2){
                answer[0] = i;
            }
            else if(hash[i]==0){
                answer[1] = i;
            }
        }
        return answer;
    }
}