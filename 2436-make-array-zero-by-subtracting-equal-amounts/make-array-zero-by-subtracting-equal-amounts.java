class Solution {
    public int minimumOperations(int[] nums) {

        int count = 0;

        while(true){

            int smallest = findSmallest(nums);

            if(smallest==-1){
                break;
            }
            else{
                count++;
                for(int i = 0 ; i < nums.length ; i++){
                    nums[i] = nums[i] - smallest;
                }
            }
        }
        return count;
    }

    public int findSmallest(int[] nums){
        int answer = -1;
        Arrays.sort(nums);

        for(int elem : nums){
            if(elem > 0){
                answer = elem;
                break;
            }
        }
        return answer;

    }
}