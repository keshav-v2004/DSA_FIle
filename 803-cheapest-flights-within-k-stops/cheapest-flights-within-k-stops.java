class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] cost= new int[n];
        Arrays.fill(cost , Integer.MAX_VALUE);
        cost[src] = 0;

        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());

        }

        for(int[] each : flights){
            int x = each[0];
            int dest = each[1];
            int y = each[2];

            adj.get(x).add(new Tuple(dest , y));

        }

        // priorityQueue stores --> [cost , node , stops]
        // min heap based on minimum cost at first

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[2] , b[2]);
        });

        pq.offer(new int[]{0,src , 0});

        while(!pq.isEmpty()){

            int[] cur = pq.poll();

            int curCost = cur[0];
            int curNode = cur[1];
            int stopsTillHere = cur[2];

            if(stopsTillHere > k) continue;


            ArrayList<Tuple> neighbours = adj.get(curNode);


            for(Tuple nbr : neighbours){

                int dest = nbr.dest;
                int costForThis = nbr.cost;

                int newCost = curCost + costForThis;

                if(cost[dest] > newCost){

                    cost[dest] = newCost;

                    pq.offer(new int[]{cost[dest] , dest , stopsTillHere+1});
                }
            }
        }

        if(cost[dst] == Integer.MAX_VALUE) return -1;
        return cost[dst];
    }
}

class Tuple{
    int dest;
    int cost;

    Tuple(int dest , int cost){
        this.dest = dest;
        this.cost = cost;
    }
}