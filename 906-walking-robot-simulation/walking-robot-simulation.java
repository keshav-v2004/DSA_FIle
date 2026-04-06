class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int x = 0, y = 0;
        int maxDist = 0;

        // 0 = North, 1 = East, 2 = South, 3 = West
        int dir = 0;

        for (int cmd : commands) {

            if (cmd == -2) {
                // turn left
                dir = (dir + 3) % 4;
            } 
            else if (cmd == -1) {
                // turn right
                dir = (dir + 1) % 4;
            } 
            else {
                // move forward step by step
                for (int i = 0; i < cmd; i++) {

                    int nextX = x;
                    int nextY = y;

                    if (dir == 0) nextY++;       // North
                    else if (dir == 1) nextX++;  // East
                    else if (dir == 2) nextY--;  // South
                    else nextX--;                // West

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}