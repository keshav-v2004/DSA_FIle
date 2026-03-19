class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ArrayList<ArrayList<int[]>> col = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            col.add(new ArrayList<>());

        }

        for (ArrayList<int[]> each : col) {

            for (int j = 0; j < n; j++) {
                each.add(new int[3]);
            }

        }

        for (int j = 0; j < n; j++) {
            char ch = grid[0][j];

            ArrayList<int[]> each = col.get(0);

            if (ch == 'X') {
                each.get(j)[0]++;
            } else if (ch == 'Y') {
                each.get(j)[1]++;
            } else {
                each.get(j)[2]++;
            }
        }

        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {

                char ch = grid[i][j];

                col.get(i).get(j)[0] = col.get(i - 1).get(j)[0];

                col.get(i).get(j)[1] = col.get(i - 1).get(j)[1];

                col.get(i).get(j)[2] = col.get(i - 1).get(j)[2];

                if (ch == 'X') {
                    col.get(i).get(j)[0]++;

                } else if (ch == 'Y') {
                    col.get(i).get(j)[1]++;
                } else {
                    col.get(i).get(j)[2]++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            int freqX = 0;
            int freqY = 0;

            for (int j = 0; j < n; j++) {

                freqX += col.get(i).get(j)[0];
                freqY += col.get(i).get(j)[1];

                if (freqX == freqY && freqX >= 1) {
                    count++;
                }

            }
        }

        return count;
    }
}
