class Solution {


    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    maxArea = Math.max(maxArea , dfs(i,j,grid,visited ));
                }
            }
        }
        return maxArea;

    }

    public int dfs(int i , int j , int[][] grid , boolean[][] visited ){

        if(
            i >= grid.length || 
            j >= grid[0].length || i < 0 || j < 0 || visited[i][j]==true ||
            grid[i][j]==0
        ){
            return 0;
        }

        visited[i][j] = true;
        int top = dfs(i-1 , j , grid , visited );
        int bottom = dfs(i+1 , j , grid , visited);
        int left = dfs(i,j-1 , grid,visited);
        int right = dfs(i , j+1 , grid , visited);
        
        
        if(grid[i][j]==1){
            return 1 +top+bottom+left+right;
        }
        return top+bottom+left+right;

    }
}