class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int len1 = ax2 - ax1;
        int w1   = ay2 - ay1;

        int len2 = bx2 - bx1;
        int w2   = by2 - by1;

        int total = len1*w1 + len2*w2;

        int xOverlap = Math.max(0 , Math.min(ax2 , bx2) - Math.max(ax1,bx1));
        int yOverlap = Math.max(0 , Math.min(ay2 , by2) - Math.max(ay1,by1));

        if(xOverlap > 0 && yOverlap > 0){
            return total - xOverlap*yOverlap; 
        }
        return total;
        

    }
}