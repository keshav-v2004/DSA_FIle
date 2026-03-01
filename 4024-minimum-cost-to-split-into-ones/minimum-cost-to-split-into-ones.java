class Solution {
    public int minCost(int n) {
        if(n==1) return 0;

        int op1 = 1;
        int op2 = n-1;
        int cost = 0;


        while(op2 > 0){
            cost += op2;
            op2--;
        }
        return cost;
    }
}