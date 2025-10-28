class Solution {
    public int majorityElement(int[] nums) {
        Integer answer = null;
        int count = 0;

        for(int elem : nums){
            if(count==0 && answer==null){
                answer = elem;
                count++;
            }
            else if(answer==elem){
                count++;
            }
            else{
                count--;
                if(count==0){
                    answer=elem;
                    count++;
                }
            }
        }
        return answer;
    }
}