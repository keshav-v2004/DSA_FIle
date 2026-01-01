class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();

        if(nums.length==0) return answer;

        int start = nums[0];
        int end = nums[0];

        for(int i = 1 ; i < nums.length ; i++){

            if(nums[i] != end+1){

                if(start==end){
                    answer.add(String.valueOf(end));
                }
                else{
                    answer.add("%s->%s".formatted(start,end));
                }
                start = nums[i];
                end = nums[i];
            }
            else{
                end = nums[i];
            }
        }
        if(end==start){
            answer.add(String.valueOf(end));

        }
        else{
            answer.add("%s->%s".formatted(start , end));
        }
        return answer;
    }
}