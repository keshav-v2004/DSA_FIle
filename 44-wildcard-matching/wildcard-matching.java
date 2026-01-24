class Solution {
    public boolean isMatch(String s, String p) {
        int i = s.length();
        int j = p.length();

        Boolean[][] dp = new Boolean[i][j];

        return helper(s,p,i-1,j-1 , dp);
    }

    public boolean helper(String s , String p , int i , int j , Boolean[][] dp){

        if(i < 0 || j < 0){

            if(i < 0 && j < 0) return true;

            if(i < 0){

                for(int index = j ; index >=0 ; index--){
                    char ch = p.charAt(index);

                    if(ch == '?' || ch != '*'){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        if(dp[i][j] != null) return dp[i][j];

        char ch1 = s.charAt(i);
        char ch2 = p.charAt(j);

        boolean answer;

        if(ch1==ch2){
            answer = true && helper(s,p,i-1,j-1 , dp);

        }
        else{
            if(ch2=='?'){
                answer = true && helper(s,p,i-1,j-1 , dp);
            }
            else if(ch2=='*'){
                boolean moveS = helper(s,p,i-1,j , dp);
                boolean moveP = helper(s,p,i,j-1 ,dp);

                answer = moveS || moveP;
            }
            else{
                answer = false;
            }
        }

        return dp[i][j] = answer;
    }
}