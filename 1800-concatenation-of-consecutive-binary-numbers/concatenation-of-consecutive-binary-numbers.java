class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder str = new StringBuilder();

        for(int i = 1 ; i<= n ; i++){
            String s = Integer.toBinaryString(i);

            str.append(s);
        }

        long answer = 0;
        long base = 1;

        int mod = 1000000007;

        for(int i = str.length()-1 ; i>= 0 ; i--){
            int digit = str.charAt(i) - '0';

            answer = (answer + base*digit) % mod;
            base = (base * 2) % mod;

        }
        return (int)answer;
        
    }
}