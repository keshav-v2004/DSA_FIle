class Robot {

    int x = 0;
    int y = 0;

    int m;
    int n;

    int dir = 1;

    int cycle;


    // 0 1 2 3
    // North East South West

    public Robot(int width, int height) {
        m = width;
        n = height;

        cycle = 2*(m+n) - 4;

    }
    
    public void step(int num) {

        num = num % cycle;

        if(num == 0){
            if(x==0 && y ==0){
                dir = 2;
                return;
            }
        }

        int i = 0;

        while(i < num){
            int newX = x;
            int newY = y;

            if(dir == 0) newY++;
            else if(dir==1) newX++;
            else if(dir==2) newY--;
            else if(dir==3) newX--;

            if(newX >= 0 && newX < m && newY >= 0 && newY < n){
                x = newX;
                y = newY;
                i++;
            }
            else{
                dir = (dir+3) % 4;
            }
        }
        

    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        if(dir==0){
            return "North";
        }
        else if(dir==1){
            return "East";
        }
        else if(dir==2){
            return "South";
        }
        else{
            return "West";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */