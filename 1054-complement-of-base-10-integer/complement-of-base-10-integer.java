class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int number = 0;

        int base = 1;

        while(n > 0){
            int rem = n % 2;

            if(rem == 0){
                number = number + base;
            }
            base = base*2;
            n = n / 2;

        }
        return number;
    }
}