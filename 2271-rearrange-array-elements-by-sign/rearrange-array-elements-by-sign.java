class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] answer = new int[nums.length];

        int pos = 0;
        int neg = 1;

        for(int elem : nums){
            if(elem > 0){
                answer[pos] = elem;
                pos+=2;
            }
            else{
                answer[neg] = elem;
                neg+=2;
            }
        }
        return answer;
    }
}