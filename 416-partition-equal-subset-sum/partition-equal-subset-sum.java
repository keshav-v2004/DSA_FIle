class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int elem : nums){
            sum+=elem;
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        Boolean[][] dp= new Boolean[nums.length][target+1];

        return helper(nums , 0 , target , dp);


        
    }

    public boolean helper(int[] arr , int index , int sum , Boolean[][] dp){

        if(sum < 0) return false;

        if(index>= arr.length){
            if(sum==0){
                return true;
            }
            return false;
        }

        if(dp[index][sum] != null) return dp[index][sum];

        boolean pick = helper(arr , index+1 , sum - arr[index] , dp);
        boolean notPick = helper(arr , index+1 , sum , dp);

        return dp[index][sum] = pick || notPick;
    }
}