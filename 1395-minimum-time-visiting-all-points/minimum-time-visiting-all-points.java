class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int answer = 0;

        for(int i = 0 ; i < points.length-1 ; i++){
            
            int x1= points[i][0];
            int y1= points[i][1];

            int x2= points[i+1][0];
            int y2= points[i+1][1];

            int aD = Math.abs(x1-x2);
            int oD = Math.abs(y1-y2);

            answer+=Math.max(aD , oD);
        }

        return answer;
    }
}