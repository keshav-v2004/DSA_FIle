class Solution {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);

    }

    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();

        int i = s.length();
        int j = s.length();

        int[][] dp = new int[i + 1][i + 1];

        for (int k = 0; k < i + 1; k++) {
            dp[0][k] = 0;
            dp[k][0] = 0;

        }

        for (int k = 1; k < i + 1; k++) {
            for (int l = 1; l < j + 1; l++) {
                char ch1 = s.charAt(k - 1);
                char ch2 = r.charAt(l - 1);

                if (ch1 == ch2) {
                    dp[k][l] = 1 + dp[k - 1][l - 1];
                } else {
                    dp[k][l] = Math.max(dp[k - 1][l], dp[k][l - 1]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        i = s.length();
        j = s.length();

        while (i > 0 && j > 0) {
            int cur = dp[i][j];

            if (cur > Math.max(dp[i - 1][j], dp[i][j - 1])) {
                answer.append(s.charAt(i - 1));
                i--;
                j--;
            } else {
                if (cur == dp[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // longest palindromic subsequence
        System.out.println(answer.reverse().toString());

        return answer.length();
    }

}