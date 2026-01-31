class Solution {
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();

        int[][] dp = new int[i + 1][j + 1];

        for (int k = 0; k < dp[0].length; k++) {
            dp[0][k] = k;
        }
        for (int k = 0; k < dp.length; k++) {
            dp[k][0] = k;
        }
        dp[0][0] = 0;
        for (int k = 1; k < i + 1; k++) {
            for (int l = 1; l < j + 1; l++) {
                char ch1 = word1.charAt(k - 1);
                char ch2 = word2.charAt(l - 1);

                
                if (ch1 == ch2) {
                    dp[k][l] = dp[k-1][l-1];
                } else {
                    dp[k][l] = 1 + Math.min(
                            dp[k-1][l], dp[k][l-1]);
                }
            }
        }

        return dp[i][j];

    }

    public int helper(String word1, String word2, int i, int j, int[][] dp) {

        if (i == 0 || j == 0) {
            if (i == 0 && j == 0)
                return 0;
            else if (i == 0)
                return j;
            return i;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        char ch1 = word1.charAt(i - 1);
        char ch2 = word2.charAt(j - 1);

        int answer = 0;
        if (ch1 == ch2) {
            answer = helper(word1, word2, i - 1, j - 1, dp);
        } else {
            answer = 1 + Math.min(
                    helper(word1, word2, i - 1, j, dp), helper(word1, word2, i, j - 1, dp));
        }

        return dp[i][j] = answer;
    }
}