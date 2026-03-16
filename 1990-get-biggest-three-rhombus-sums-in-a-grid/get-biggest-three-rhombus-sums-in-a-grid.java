import java.util.*;

class Solution {

    public int diagonalLength = 0;

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                diagonalLength = Math.min((m - i - 1) / 2, Math.min(j, n - j - 1));

                for (int d = 0; d <= diagonalLength; d++) {

                    int sum = findRhombusSum(i, j, m, n, d, grid);

                    if (set.add(sum))
                        pq.offer(sum);
                }
            }
        }

        int k = Math.min(3, pq.size());
        int[] output = new int[k];

        for (int i = 0; i < k; i++)
            output[i] = pq.poll();

        return output;
    }

    public int findRhombusSum(int i, int j, int m, int n, int d, int[][] grid) {

        if (d == 0)
            return grid[i][j];

        int sum = 0;

        int x = i;
        int y = j;

        // edge 1: top -> left
        for (int k = 0; k < d; k++) {
            sum += grid[x][y];
            x++;
            y--;
        }

        // edge 2: left -> bottom
        for (int k = 0; k < d; k++) {
            sum += grid[x][y];
            x++;
            y++;
        }

        // edge 3: bottom -> right
        for (int k = 0; k < d; k++) {
            sum += grid[x][y];
            x--;
            y++;
        }

        // edge 4: right -> top
        for (int k = 0; k < d; k++) {
            sum += grid[x][y];
            x--;
            y--;
        }

        return sum;
    }
}