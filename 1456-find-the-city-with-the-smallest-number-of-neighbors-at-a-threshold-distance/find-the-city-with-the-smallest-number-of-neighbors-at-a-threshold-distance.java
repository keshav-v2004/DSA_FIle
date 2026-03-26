class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adj = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){

                if(i==j){
                    continue;
                }

                else{
                    adj[i][j] = Integer.MAX_VALUE;

                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u][v] = w;
            adj[v][u] = w;
        }

        for(int k = 0 ; k < n ; k++){

            for(int i = 0 ; i < n ; i++){

                for(int j = 0 ; j < n ; j++){

                    if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE){
                        adj[i][j] = Math.min(adj[i][j] , (adj[i][k] + adj[k][j]));
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int city = -1;

        for(int i = 0 ; i < n ; i++){

            int count= 0;

            for(int j = 0 ; j < n ; j++){

                if(i==j) continue;

                if(adj[i][j] <= distanceThreshold){
                    count++;

                }
            }
            if(count <= min){
                min = count;
                city = i;
            }
        }
        return city;


    }
}

class Pair{
    int node;
    int cost;

    Pair(int node , int cost){
        this.node = node;
        this.cost = cost;

    }

}