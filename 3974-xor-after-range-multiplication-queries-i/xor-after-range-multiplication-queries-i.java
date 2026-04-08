class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        

        long mod = (int)1e9 + 7;

        for(int[] each : queries){

            int l = each[0];
            int r = each[1];
            int k = each[2];
            int v = each[3];

            int index = l;

            while(index <= r){
                nums[index] = (int)((nums[index] * 1L * v) % mod);
                index += k;
            }
        }
        int xor = 0;
        for(int elem : nums){
            xor = xor ^ elem;
        }
        return xor;
    }
}