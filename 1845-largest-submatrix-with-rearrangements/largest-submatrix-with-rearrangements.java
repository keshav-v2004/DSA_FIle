class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int answer = 0;

        for (int i = 0; i < m; i++) {

            
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) heights[j] = 0;
                else heights[j]++;
            }

            
            int[] temp = heights.clone();
            Arrays.sort(temp);

            for (int j = 0; j < n; j++) {
                int h = temp[j];
                int width = n - j;
                answer = Math.max(answer, h * width);
            }
        }

        return answer;
    }
}