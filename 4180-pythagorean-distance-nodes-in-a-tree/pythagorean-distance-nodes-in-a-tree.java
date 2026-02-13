class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }


        for(int[] pair : edges){
            int u = pair[0];
            int v = pair[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] fromX = bfs(x , adj);
        int[] fromY = bfs(y,adj);
        int[] fromZ = bfs(z,adj);

        int count = 0;


        for(int i = 0 ; i < fromX.length ; i++){

            long[] dist = new long[3];
            dist[0] = (long)fromX[i];
            dist[1] = (long)fromY[i];
            dist[2] = (long)fromZ[i];

            Arrays.sort(dist);
            if(dist[0]*dist[0] + dist[1]*dist[1] == dist[2]*dist[2]){
                count++;
            }
        }
        return count;
    }

    public int[] bfs(int start , ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[adj.size()];

        
        Queue<Integer> q = new LinkedList<>();

        int[] distances = new int[adj.size()];
        Arrays.fill(distances , (int) 1e9);

        distances[start] = 0;
        q.offer(start);
        visited[start] = true;


        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int neighbour : adj.get(cur)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    distances[neighbour] = distances[cur] + 1;
                    q.offer(neighbour);
                }
            }
        }
        return distances;
    }
}