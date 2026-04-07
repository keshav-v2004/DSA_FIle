class Robot {

    int x = 0, y = 0;
    int w, h;
    int dir = 1; // 0=N, 1=E, 2=S, 3=W
    int cycle;

    public Robot(int width, int height) {
        w = width;
        h = height;
        cycle = 2 * (w + h) - 4;
    }
    
    public void step(int num) {
        num %= cycle;

        if (num == 0) {
            if (x == 0 && y == 0) dir = 2; 
            return;
        }

        while (num > 0) {

            if (dir == 1) { // East
                int move = Math.min(num, w - 1 - x);
                x += move;
                num -= move;
                if (move == 0) dir = 0;
            }

            else if (dir == 0) { // North
                int move = Math.min(num, h - 1 - y);
                y += move;
                num -= move;
                if (move == 0) dir = 3;
            }

            else if (dir == 3) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (move == 0) dir = 2;
            }

            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (move == 0) dir = 1;
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        String[] d = {"North", "East", "South", "West"};
        return d[dir];
    }
}