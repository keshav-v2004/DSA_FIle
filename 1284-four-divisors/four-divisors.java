class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for(int elem : nums){
            sum+=divisorFind(elem);
        }
        return sum;
    }
    public int divisorFind(int n){
        int count = 0;
        int sum = 0;
        for(int i = 1 ; i * i <=  n ; i++){
            if(n % i ==0){
                int j = n / i;
                if (i == j) {         
                    count += 1;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + j;
                }
            }
        }
        if(count==4) return sum;
        return 0;
    }
}