class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;

        // check if given matrix equal to target
        boolean isSame = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame == true) {
            return true;
        }

        int[][] m1 = new int[n][n];
        int[][] m2 = new int[n][n];
        int[][] m3 = new int[n][n];

        // create m1 (90 degree anti clock)

        int x = n - 1;
        int y = 0;

        for (int i = 0; i < n; i++) {

            x = n - 1;

            for (int j = 0; j < n; j++) {
                m1[x][y] = mat[i][j];
                x--;

            }
            y++;
        }

        isSame = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (m1[i][j] != target[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame == true)
            return true;

        // create m2 (180 degree anti clock)

        x = n - 1;
        y = 0;

        for (int i = 0; i < n; i++) {

            x = n - 1;

            for (int j = 0; j < n; j++) {
                m2[x][y] = m1[i][j];
                x--;

            }
            y++;
        }

        isSame = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (m2[i][j] != target[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame == true)
            return true;

        // create m3 (270 degree anti clock)

        x = n - 1;
        y = 0;

        for (int i = 0; i < n; i++) {

            x = n - 1;

            for (int j = 0; j < n; j++) {
                m3[x][y] = m2[i][j];
                x--;

            }
            y++;
        }

        isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (m3[i][j] != target[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame == true)
            return true;

        return false;

    }
}