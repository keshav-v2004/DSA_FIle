class Solution {
    public int mirrorDistance(int n) {

        return Math.abs(n - findReverse(n));


    }

    public int findReverse(int n){
        int reverseNumber = 0;
        while(n>0){
            int digit = n % 10;

            reverseNumber = reverseNumber*10 + digit;

            n = n / 10;
        }

        return reverseNumber;



    }
}