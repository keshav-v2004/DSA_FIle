class Solution {
    Integer[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        memo = new Integer[s1.length()][s2.length()];
        return solve(s1, s2, 0, 0);
    }

    private int solve(String s1, String s2, int i, int j) {
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }
            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }
            return sum;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int result;
        if (s1.charAt(i) == s2.charAt(j)) {
            result = solve(s1, s2, i + 1, j + 1);
        } else {
            result = Math.min(
                s1.charAt(i) + solve(s1, s2, i + 1, j),
                s2.charAt(j) + solve(s1, s2, i, j + 1)
            );
        }

        memo[i][j] = result;
        return result;
    }
}
