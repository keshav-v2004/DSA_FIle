class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int canDrink = 0;
        int empty = 0;
        while (numBottles > 0){
            
            canDrink+=numBottles;
            
            empty += numBottles;
            
            int quot = empty / numExchange;
            numBottles = quot;
            
            empty = empty - (quot * numExchange);
            
        }
        return canDrink;
    }
}