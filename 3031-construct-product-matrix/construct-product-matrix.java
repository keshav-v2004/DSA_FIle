class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] suffix = new int[m][n];
        int[][] prefix = new int[m][n];

        int mod = 12345;

        long prod = 1;

        // Suffix
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                suffix[i][j] = (int) prod;
                prod = (prod * (grid[i][j] % mod)) % mod;
            }
        }

        // Prefix
        prod = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = (int) prod;
                prod = (prod * (grid[i][j] % mod)) % mod;
            }
        }

        // Answer
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = (int)((1L * prefix[i][j] * suffix[i][j]) % mod);
            }
        }

        return answer;
    }
}