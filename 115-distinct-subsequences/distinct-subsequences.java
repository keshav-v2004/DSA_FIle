class Solution {
    Integer[][] dp;

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return helper(s, t, s.length() - 1, t.length() - 1);
    }

    public int helper(String s, String t, int i, int j) {

        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int count = helper(s, t, i - 1, j); // skip

        if (s.charAt(i) == t.charAt(j)) {
            count += helper(s, t, i - 1, j - 1); // use
        }

        return dp[i][j] = count;
    }
}
