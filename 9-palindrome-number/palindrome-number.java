class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int reverseNumber = 0;
        int orig = x;

        while(x > 0){
            int digit = x % 10;
            x/=10;

            reverseNumber = reverseNumber*10 + digit;

        }   
        return reverseNumber==orig;
        
    }
}