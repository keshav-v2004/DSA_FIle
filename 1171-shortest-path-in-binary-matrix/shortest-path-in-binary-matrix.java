class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[m][n];

        for(int[] each : visited){
            Arrays.fill(each , Integer.MAX_VALUE);
        }

        visited[0][0] = 1;

        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            
            int[] cur = q.poll();

            int curR = cur[0];
            int curCol = cur[1];

            for(int i = -1 ; i<= 1 ; i++){
                for(int j = -1 ; j <= 1 ; j++){

                    if(i==0 && j == 0) continue;

                    int newR = curR + i;
                    int newCol = curCol +j;

                    if(newR >= 0 && newCol >= 0 && newR < m && newCol < n && grid[newR][newCol] == 0){
                        if(visited[newR][newCol] > visited[curR][curCol] + 1){
                            visited[newR][newCol] = visited[curR][curCol] + 1;

                            q.offer(new int[]{newR , newCol});
                        }
                    }
                }
            }
        }

        if(visited[m-1][n-1] == Integer.MAX_VALUE) return -1;

        return visited[m-1][n-1];
    }
}