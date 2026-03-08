class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();

        for(String str : nums){
            set.add(str);
        }

        int n = nums.length;

        int ub = (int) Math.pow(2, n);

        for(int i = 0; i < ub; i++){
            String x = Integer.toBinaryString(i);

            while(x.length() < n){
                x = "0" + x;
            }

            if(!set.contains(x)){
                return x;
            }
        }

        return "";
    }
}