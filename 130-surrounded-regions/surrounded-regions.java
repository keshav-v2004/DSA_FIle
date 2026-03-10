class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        ArrayList<ArrayList<int[]>> allPossibleRegions = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];

        for (int i = 1; i < m - 1; i++) {

            for (int j = 1; j < n - 1; j++) {

                char ch = board[i][j];

                if (ch == 'O' && visited[i][j]==false) {

                    ArrayList<int[]> eachRegion = new ArrayList<>();
                    dfs(i, j, visited, eachRegion , board);

                    allPossibleRegions.add(eachRegion);

                } else {
                    visited[i][j] = true;

                }
            }
        }

        for (ArrayList<int[]> each : allPossibleRegions) {

            boolean isPossible = true;

            for (int[] elem : each) {
                int r = elem[0];
                int c = elem[1];

                if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible == true) {
                for (int[] elem : each) {
                    int r = elem[0];
                    int c = elem[1];

                    board[r][c] = 'X';
                }
            }
        }

    }

    public void dfs(int i, int j, boolean[][] visited, ArrayList<int[]> each , char[][] grid) {

        visited[i][j] = true;
        each.add(new int[] { i, j });

        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        int m = visited.length;
        int n = visited[0].length;

        for (int k = 0; k < 4; k++) {
            int newR = i + dx[k];
            int newCol = j + dy[k];

            if (newR < m  && newCol < n  && newR >= 0 && newCol >= 0 && 
            visited[newR][newCol] == false && grid[newR][newCol]=='O') {

                dfs(newR, newCol, visited, each , grid);
            }
        }

    }

}