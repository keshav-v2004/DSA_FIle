class Solution {
    public int smallestNumber(int n) {
        while (true){
            if (helper(n)) return n;
            n++;
        }
    }
    
    private boolean helper(int n){
        String x = Integer.toBinaryString(n);
        for (char ch : x.toCharArray()){
            if (ch=='0'){
                return false;
            }
        }
        return true;
    }
}