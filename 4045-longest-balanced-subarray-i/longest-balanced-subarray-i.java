class Solution {
    public int longestBalanced(int[] nums) {
        
        int maxLen = 0;
        int n = nums.length;


        for(int i = 0 ; i < n ; i++){

            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            int elem = nums[i];

            if(elem % 2 ==0){
                even.add(elem);
            }
            else{
                odd.add(elem);
            }

            for(int j = i+1 ; j < n ; j++){
                int x = nums[j];

                if(x % 2 == 0){
                    even.add(x);
                }
                else{
                    odd.add(x);
                }
                if(even.size()==odd.size()){
                    maxLen = Math.max(maxLen , j-i+1);
                }
            }
        }
        return maxLen;

    }
}