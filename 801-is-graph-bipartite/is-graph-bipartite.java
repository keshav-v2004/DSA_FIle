class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;


        int[] visited = new int[n];
        Arrays.fill(visited , -1);

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == -1){
                if(bfs(i,graph , visited) == false){
                    return false;
                }
            }
        }
        return true;


    }

    public boolean bfs(int i , int[][] adj , int[] visited){
        
        Queue<Integer> q = new LinkedList<>();
        visited[i] = 0;
        q.offer(i);

        while(!q.isEmpty()){

            int curNode = q.poll();
            int curColor = visited[curNode];

            int[] neighbours = adj[curNode];

            for(int elem : neighbours){

                if(visited[elem] == -1){
                    
                    q.offer(elem);

                    if(curColor==0){
                        visited[elem] = 1;
                    }
                    else{
                        visited[elem] = 0;
                    }
                }
                else{
                    if(curColor==visited[elem]){
                        return false;
                    }
                }

            }
        }
        
        return true;

    }
}