class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[m][n];
        visited[0][0] = 1;

        int distance = 1;

        q.offer(new int[] { 0, 0 });

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();

                int curR = cur[0];
                int curC = cur[1];

                if (curR == m - 1 && curC == n - 1) {
                    return distance;
                }

                for(int dx = -1 ; dx <= 1 ; dx++){

                    for(int dy = -1 ; dy <= 1 ; dy++){

                        if(dx==0 && dy==0) continue;

                        int newR = curR + dx;
                        int newCol = curC + dy;

                        if(newR >= 0 && newCol >= 0 && newR < m && newCol < n && grid[newR][newCol] == 0 && visited[newR][newCol] == 0){

                            q.offer(new int[]{newR , newCol});
                            visited[newR][newCol] = 1;
                        }
                    }
                }



            }
            distance++;

        }

        return -1;
    }
}