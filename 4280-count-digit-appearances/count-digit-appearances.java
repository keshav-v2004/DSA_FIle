class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        
        int answer = 0;

        for(int elem : nums){
            answer = answer + helper(elem , digit);
        }

        return answer;
    }

    public int helper(int number , int digit){

        int count = 0;

        int n = number;
        while(n > 0){

            int x = n % 10 ;
            n = n / 10;

            if(x==digit){
                count++;
            }
        }
        return count;


    }
}