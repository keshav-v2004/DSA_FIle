class Solution {
    public int minimumDistance(String word) {
        
        Integer[][][] dp = new Integer[word.length()][27][27];

        return helper(word , word.length()-1 , 26 , 26 , dp);


    }

    public int helper(String word , int index , int finger1Pos , int finger2Pos , Integer[][][] dp){

        if(index < 0){
            return 0;
        }

        if(dp[index][finger1Pos][finger2Pos] != null) return dp[index][finger1Pos][finger2Pos];

        int cur = word.charAt(index) - 'A';

        // click it via finger 1 --> updated finger1Pos = cur , finger2Pos remains unchanged
        int move1 = findDistance(finger1Pos , cur) + helper(word , index-1 , cur , finger2Pos , dp);

        // click it via finger 2 --> updated finger2Pos = cur , finger1Pos remains unchanged

        int move2 = findDistance(finger2Pos , cur) + helper(word , index-1 , finger1Pos , cur ,dp);

        return dp[index][finger1Pos][finger2Pos] = Math.min(move1 , move2);


    }

    public int findDistance(int a , int b){

        if( a == 26 || b == 26 ) return 0;

        int r1 = a / 6;
        int c1 = a % 6;

        int r2 = b / 6;
        int c2 = b % 6;

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);

    }
}