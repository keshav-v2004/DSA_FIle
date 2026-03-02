class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int streak = 0;

        for(int elem : nums){
            if(elem == 1){
                streak++;
                answer = Math.max(answer , streak);
            }
            else{
                streak = 0;
            }
        }
        return answer;
    }
}