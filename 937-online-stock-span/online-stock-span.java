class StockSpanner {

    ArrayList<Integer> prices ;


    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        if(prices.isEmpty()) {
            prices.add(price);
            return 1;
        }
        else{
            int span = 0;
            prices.add(price);
            for(int i = prices.size()-1 ; i>= 0 ; i--){
                if(prices.get(i) <= price){
                    span++;
                }
                else{
                    break;
                }
            }
            
            return span;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */