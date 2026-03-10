class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;


        int[][] output = new int[m][n];
        int[][] visited = new int[m][n];

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();


        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(mat[i][j] == 0){
                    visited[i][j] = 1;
                    int[] each = new int[]{i,j,0};
                    q.offer(each);
                }
            }
        }

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int d = cur[2];

            output[i][j] = d;

            for(int k = 0 ; k < 4 ; k++){


                int newR = i + dx[k];
                int newCol = j + dy[k];

                if(newR < m && newR >= 0 && newCol < n && newCol >= 0 && visited[newR][newCol] == 0){
                    int[] each = new int[]{newR,newCol , d+1};
                    q.offer(each);
                    visited[newR][newCol] = 1;
                }
            }

        }



        return output;
        
    }

}