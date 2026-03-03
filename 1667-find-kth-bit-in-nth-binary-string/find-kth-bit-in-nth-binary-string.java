class Solution {
    public char findKthBit(int n, int k) {

        String[] dp = new String[n+1];

        
        String str = helper(n , dp);

        return str.charAt(k-1);

    }

    public String helper(int n , String[] dp){

        if(n==1){
            return "0";
        }

        if(dp[n] != null) return dp[n];

        String prev = helper(n-1 , dp);

        String inverted = invert(prev);
        String reversed = new StringBuilder(inverted).reverse().toString();

        String current = prev + "1" + reversed;

        return dp[n] = current;

    }

    public String invert(String s){
        StringBuilder answer = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch=='0'){
                answer.append('1');
            }
            else{
                answer.append('0');
            }
        }
        return answer.toString();
    }

}