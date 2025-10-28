class Solution {
    public int maxProfit(int[] prices) {
        int mp =0;
        int lp = prices[0];
        int n = prices.length;
        for(int i = 1 ; i < n ; i++){
            int elem = prices[i];
            if(elem < lp){
                lp = elem;
            }
            else{
                mp = Math.max(mp , elem - lp);
            }
        }
        return mp;
    }
}