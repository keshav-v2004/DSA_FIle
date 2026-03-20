class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] answer = new int[rows - k+1][cols - k +1];

        for(int i = 0 ; i <= rows - k ; i++){
            for(int j = 0 ; j <= cols-k ; j++){

                ArrayList<Integer> each = new ArrayList<>();

                for(int l = i ; l < k+i ; l++){
                    for(int m = j ; m < k+j ; m++){
                        each.add(grid[l][m]);
                    }
                }

                int diff = helper(each);

                answer[i][j] = diff;
            }
        } 
        return answer;  
    }
    public int helper(ArrayList<Integer> each){

        Collections.sort(each);

        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i < each.size()-1 ; i++){

            int first = each.get(i);
            int sec = each.get(i+1);

            if(first != sec){
                answer = Math.min(answer , sec - first);
            }
        }
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;

    }
}