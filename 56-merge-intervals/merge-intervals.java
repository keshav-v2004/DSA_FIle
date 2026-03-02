class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> {
            return Integer.compare(a[0] , b[0]);
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        ArrayList<int[]> answer = new ArrayList<>();

        for(int i = 1 ; i < intervals.length ; i++){
            int curEnd = intervals[i][1];
            int curStart = intervals[i][0];

            if(end >= curStart){
                end = Math.max(end , curEnd);
            }
            else{
                int[] interval = new int[]{start , end};
                answer.add(interval);
                start = curStart;
                end = curEnd;
            }
        }
        answer.add(new int[]{start , end});
        int[][] output = new int[answer.size()][2];

        for(int i = 0 ; i < answer.size() ; i++){
            output[i] = answer.get(i);

        }
        return output;

    }
}