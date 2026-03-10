class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0  ; j < n ; j++){

                if(grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    dfs(grid , visited , i , j);
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid , int[][] visited , int i , int j){

        visited[i][j] = 1;
        
        int m = grid.length;
        int n = grid[0].length;

        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        for(int k = 0 ; k < 4 ; k++){

            int newR = i + dx[k];
            int newCol = j + dy[k];

            if(newR >= 0 && newCol >= 0 && newR < m && newCol < n && visited[newR][newCol] == 0 
                && grid[newR][newCol] == '1' 
            ){
                dfs(grid , visited , newR , newCol);

            }


        }
    }
}