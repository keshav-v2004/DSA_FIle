class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        Integer[][][] dp = new Integer[m][n][3];

        return helper(0 , 0 , coins , 2 , dp);
    }

    public int helper(int i , int j , int[][] coins , int neutralCount , Integer[][][] dp){

        int m = coins.length;
        int n = coins[0].length;

        if(i >= m || j >= n){
            return Integer.MIN_VALUE;
        }

        if(i == m-1 && j == n-1){
            if(coins[i][j] >= 0){
                return coins[i][j];

            }
            else{
                if(neutralCount > 0){
                    return 0;
                }
                else{
                    return coins[i][j];
                }
            }
        }

        if(dp[i][j][neutralCount] != null) return dp[i][j][neutralCount];

        int cur = coins[i][j];
        int amount = 0;

        // if current amount < 0 --> simply gain it
        
        // else{

        //     let the robot steal and keep neutral count as it is
        // decrement amount
        //     if allowed dont let the robot steal and decrement the neutral count by 1

        // }

        if(cur >= 0){
            amount += cur;
            
            int downAmount = helper(i+1 , j , coins , neutralCount , dp);
            int rightAmount = helper(i,j+1,coins , neutralCount , dp);

            return dp[i][j][neutralCount] = amount + Math.max(downAmount , rightAmount); 
        }
        else{

            
            int downAmount = helper(i+1 , j , coins , neutralCount , dp);
            int rightAmount = helper(i,j+1,coins , neutralCount , dp);

            int case1amount = amount - Math.abs(cur) + Math.max(downAmount , rightAmount);

            int case2amount = Integer.MIN_VALUE;

            if(neutralCount > 0){
                
                int x = helper(i+1 , j , coins , neutralCount-1 , dp);
                int y = helper(i,j+1,coins , neutralCount-1 , dp);

                case2amount = amount + Math.max(x , y);
            }

            return dp[i][j][neutralCount] = Math.max(case1amount , case2amount);
        }




    }
}