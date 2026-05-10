class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;

        int[] answer = new int[2*n];

        int index = 0;

        for(int i = 0 ; i < n ; i++){
            answer[index++] = nums[i];
        }

        for(int i = n-1 ; i>= 0 ; i--){
            answer[index++] = nums[i];
        }

        return answer;

    }
}