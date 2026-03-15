class Solution {

    public long minCost(String s, int encCost, int flatCost) {
        return helper(s, encCost, flatCost);
    }

    public long helper(String s , int encCost , int flatCost ){

        long costOfThis = findStringCost(s , encCost, flatCost);

        int n = s.length();

        if(n % 2 != 0){
            return costOfThis;
        }

        String s1 = s.substring(0,n/2);
        String s2 = s.substring(n/2 , n);

        long c1 = helper(s1,encCost,flatCost);
        long c2 = helper(s2,encCost,flatCost);

        return Math.min(costOfThis , c1 + c2);
    }

    public long findStringCost(String s , int encCost,int flatCost){
        int n = s.length();

        int sensiCount  = 0;

        for(char ch : s.toCharArray()){
            if(ch=='1'){
                sensiCount++;
            }
        }

        if(sensiCount > 0){
            return (long)n * sensiCount * encCost;
        }
        else{
            return flatCost;
        }
    }
}