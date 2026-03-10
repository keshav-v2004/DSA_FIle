class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        // check row 0
        // check row m-1

        for (int j = 0; j < n; j++) {

            if (grid[0][j] == 1 && visited[0][j] == 0) {
                dfs(0, j, grid, visited);
            }

            if (grid[m - 1][j] == 1 && visited[m - 1][j] == 0) {
                dfs(m - 1, j, grid, visited);
            }
        }

        // check col 0
        // check col n-1

        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 1 && visited[i][0] == 0) {
                dfs(i, 0, grid, visited);
            }

            if (grid[i][n-1] == 1 && visited[i][n-1] == 0) {
                dfs(i, n-1, grid, visited);
            }
        }

        int count = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                } 
            }
        }
        return count;

    }

    public void dfs(int i, int j, int[][] grid, int[][] visited) {

        visited[i][j] = 1;

        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        int m = grid.length;
        int n = grid[0].length;

        for (int k = 0; k < 4; k++) {

            int newR = i + dx[k];
            int newCol = j + dy[k];

            if (newR >= 0 && newCol >= 0 && newR < m && newCol < n
                    && visited[newR][newCol] == 0 && grid[newR][newCol] == 1) {
                dfs(newR, newCol, grid, visited);
            }
        }
    }
}