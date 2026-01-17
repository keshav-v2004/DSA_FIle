class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();

        Integer[][] dp = new Integer[m][n];

        return helper(triangle , 0 , 0 , dp);
    }

    public int helper(List<List<Integer>> triangle , int i , int j , Integer[][] dp){

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != null) return dp[i][j];

        int bottom = helper(triangle ,i+1 , j , dp);
        int next = helper(triangle , i+1 , j+1 , dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(bottom , next);

    }
}




