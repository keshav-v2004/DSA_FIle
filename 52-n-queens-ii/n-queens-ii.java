class Solution {
    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        return helper(0, grid);
    }

    public int helper(int row, int[][] grid) {
        int n = grid.length;

        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, grid)) {
                grid[row][col] = 1;

                count += helper(row + 1, grid);

                
                grid[row][col] = 0;
            }
        }

        return count;
    }

    public boolean isSafe(int row, int col, int[][] grid) {
        int n = grid.length;

        // check column
        for (int i = 0; i < row; i++) {
            if (grid[i][col] == 1) return false;
        }

        // check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 1) return false;
        }

        // check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (grid[i][j] == 1) return false;
        }

        return true;
    }
}