class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int answer = 0;

        for(int i = left ; i <= right ; i++){
            int setBits = countSet(i);

            if(checkPrime(setBits)){
                answer++;
            }
        }
        return answer;
    }

    public int countSet(int n){
        int count = 0;

        String s = Integer.toBinaryString(n);
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                count++;
            }
        }
        return count;

    }

    public boolean checkPrime(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}