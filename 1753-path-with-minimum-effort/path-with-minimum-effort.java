class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        int[][] distance = new int[m][n];

        for(int[] each : distance){
            Arrays.fill(each , Integer.MAX_VALUE);
        }

        distance[0][0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.diff , b.diff);
        });

        pq.offer(new Edge(0,0,0));

        while(!pq.isEmpty()){

            Edge curEdge = pq.poll();

            int curDiff = curEdge.diff;
            int i = curEdge.row;
            int j = curEdge.col;

            if(curDiff > distance[i][j]) continue;

            int[] dx = new int[]{-1,0,1,0};
            int[] dy = new int[]{0,1,0,-1};

            for(int x = 0 ; x < 4 ; x++){

                int newR = i + dx[x];
                int newCol = j + dy[x];

                if(newR >= 0 && newCol >= 0 && newR < m && newCol < n){

                    int newDiff = Math.abs(heights[newR][newCol] - heights[i][j]);

                    int putThisDiff = Math.max(newDiff , curDiff);

                    if(distance[newR][newCol] > putThisDiff){
                        distance[newR][newCol] = putThisDiff;
                        pq.offer(new Edge(putThisDiff , newR , newCol));
                    }
                }

            }
        }
        return distance[m-1][n-1];
    }
}

class Edge{

    int diff;
    int row;
    int col;

    Edge(int diff , int row , int col){

        this.diff = diff;
        this.row = row;
        this.col = col;

    }


}