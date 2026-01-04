class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(
                (a[0]*a[0] + a[1]*a[1]) , (b[0]*b[0] + b[1]*b[1])
                );
        });
        for(int[] elem : points){
            pq.offer(elem);
        }
        int[][] answer = new int[k][2];

        while(k>0){
            answer[k-1] = pq.poll();
            k--;
        }
        return answer;


    }
}