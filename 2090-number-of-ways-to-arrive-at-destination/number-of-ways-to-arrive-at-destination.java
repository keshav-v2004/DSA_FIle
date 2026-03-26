class Solution {
    public int countPaths(int n, int[][] roads) {
        
        long mod = (long)1e9 + 7;

        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : roads){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            int node = cur.node;
            long dist = cur.cost;

            for(Pair nei : adj.get(node)){
                int nbr = nei.node;
                long newDist = dist + nei.cost;

                if(cost[nbr] > newDist){
                    cost[nbr] = newDist;
                    ways[nbr] = ways[node];
                    pq.offer(new Pair(nbr, newDist));
                }
                else if(cost[nbr] == newDist){
                    ways[nbr] = (ways[nbr] + ways[node]) % mod;
                }
            }
        }

        return (int)(ways[n-1] % mod);
    }
}

class Pair {
    int node;
    long cost;

    Pair(int node, long cost){
        this.node = node;
        this.cost = cost;
    }
}