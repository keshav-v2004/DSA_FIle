class Solution {
    public void solve(char[][] board) {
        
        // check the terminal rows and terminal columns 
        // terminal O's se all the saare connected O's cannot be marked
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];

        // check row 1

        for(int j = 0 ; j < n ; j++){
            if(board[0][j] == 'O'){
                dfs(0,j,visited , board);
            }
        }

        // check row m-1 (last)
                for(int j = 0 ; j < n ; j++){
            if(board[m-1][j] == 'O'){
                dfs(m-1,j,visited , board);
            }
        }

        // check column 1
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O'){
                dfs(i,0,visited , board);
            }
        }

        // check last column (n-1)
                for(int i = 0 ; i < m ; i++){
            if(board[i][n-1] == 'O'){
                dfs(i,n-1,visited , board);
            }
        }

        // now check for the other remaining inner elements

        for(int i = 1 ; i < m-1 ; i++){
            for(int j = 1 ; j < n-1 ; j++){

                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i , int j , int[][] visited , char[][] grid){

        visited[i][j] = 1;


        int m = grid.length;
        int n = grid[0].length;

        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        for(int k = 0 ; k < 4 ; k++){

            int newR = i + dx[k];
            int newCol = j + dy[k];

            if(newR < m && newCol < n && newR >= 0 && newCol >= 0 
                && visited[newR][newCol]==0 && grid[newR][newCol] == 'O'
            ){
                dfs(newR , newCol , visited , grid);
            }
        }

    }
}