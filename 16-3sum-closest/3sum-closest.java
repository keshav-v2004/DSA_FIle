class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int d = Integer.MAX_VALUE;
        int n = nums.length;
        int answer = -1;

        Arrays.sort(nums);


        for(int i = 0 ; i < n ; i++){

            int low = i+1;
            int high = n-1;

            while(low <  high ){
                if(low==i) {
                    low++;
                }
                int sum = nums[i] + nums[low] + nums[high];
                if(sum==target) return sum;

                else {
                    int diff = Math.abs(target - sum);
                    if(diff < d){
                        d = diff;
                        answer = sum;
                    }
                    if(sum > target){
                        high--;
                    }
                    else{
                        low++;
                    }
                    
                }
            }

        }
        return answer;
    }
}