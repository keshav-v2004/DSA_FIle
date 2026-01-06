class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(memo[i], -1);
        }

        return helper(0, 0, grid, health, memo);
    }

    public boolean helper(int i, int j, List<List<Integer>> grid, int health, int[][] memo) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid.get(0).size()) {
            return false;
        }

        if (grid.get(i).get(j) == 1) health--;

        if (health <= 0) return false;
        
        if (health <= memo[i][j]) return false;
        
        memo[i][j] = health;

        if (i == grid.size() - 1 && j == grid.get(0).size() - 1) {
            return true;
        }


        return helper(i + 1, j, grid, health, memo) || 
               helper(i - 1, j, grid, health, memo) || 
               helper(i, j + 1, grid, health, memo) || 
               helper(i, j - 1, grid, health, memo);
    }
}