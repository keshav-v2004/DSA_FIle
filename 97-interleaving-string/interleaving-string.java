class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();

        if (i + j != k) return false;

        Boolean[][][] dp = new Boolean[i + 1][j + 1][k + 1];

        return helper(s1, s2, s3, i, j, k, dp);
    }

    public boolean helper(String s1, String s2, String s3,
                          int i, int j, int k, Boolean[][][] dp) {

        if (i == 0 && j == 0 && k == 0) return true;

        if (dp[i][j][k] != null) return dp[i][j][k];

        boolean firstPath = false;
        boolean secondPath = false;

        if (i > 0 && k > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
            firstPath = helper(s1, s2, s3, i - 1, j, k - 1, dp);
        }

        if (j > 0 && k > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
            secondPath = helper(s1, s2, s3, i, j - 1, k - 1, dp);
        }

        return dp[i][j][k] = firstPath || secondPath;
    }
}
