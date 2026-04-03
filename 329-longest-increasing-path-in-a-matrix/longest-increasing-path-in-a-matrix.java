class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] maxLength = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j  <n ; j++){

                int[][] visited = new int[m][n];
                Integer[][] dp = new Integer[m][n];


                maxLength[i][j] = helper(i,j,matrix , visited , dp);

            }
        }

        int answer = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                answer = Math.max(answer , maxLength[i][j]);

            }
        }

        return answer;
    }

    public int helper(int i , int j , int[][] matrix , int[][] visited , Integer[][] dp){

        if(dp[i][j] !=  null) return dp[i][j];

        int m = matrix.length;
        int n = matrix[0].length;

        int longestPathLength = 1;

        int cur = matrix[i][j];
        visited[i][j] = 1;

        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        int longest = 0;

        for(int k = 0 ; k < 4 ; k++){
            int newR = i + dx[k];
            int newCol = j + dy[k];

            if(isValid(newR , newCol , m , n) == true){

                if(visited[newR][newCol] == 0 && matrix[newR][newCol] > cur){
                    longest = Math.max(longest , helper(newR , newCol , matrix , visited , dp));
                }
            }
        }
        visited[i][j] = 0;

        return dp[i][j] = longestPathLength + longest;

    }

    public boolean isValid(int i , int j , int m , int n){

        if(i >= m || i < 0 || j >= n || j < 0){
            return false;
        }
        return true;
    }

}