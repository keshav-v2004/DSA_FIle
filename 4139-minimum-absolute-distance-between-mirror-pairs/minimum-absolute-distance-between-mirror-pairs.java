class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();

        int minDistance = Integer.MAX_VALUE;


        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            
            int elem = nums[i];

            int reverseNumber = reverse(elem);

            if(map.containsKey(elem) ){

                minDistance = Math.min(minDistance , i - map.get(elem));

            }
            map.put(reverseNumber , i);


        }


        if(minDistance == Integer.MAX_VALUE){
            return -1;
        }
        return minDistance;
    }

    public int reverse(int n){

        int reverseNumber = 0;

        while(n > 0){
            int digit = n % 10;
            n = n / 10;

            reverseNumber = (reverseNumber*10) + digit;

        }
        return reverseNumber;

    }
}