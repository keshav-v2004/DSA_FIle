class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int i = 0;
        int j = 0;
        int k = 0;

        int a = str1.length();
        int b = str2.length();
        String lcs = findLCS(str1,str2);
        int c = lcs.length();

        StringBuilder answer = new StringBuilder();

        while(i < a && j < b && k < c){

            char ch1 = str1.charAt(i);
            
            char ch2 = str2.charAt(j);
            
            char ch3 = lcs.charAt(k);

            if(ch1==ch2 && ch2==ch3){
                answer.append(ch1);

                i++;
                j++;
                k++;

            }
            else{
                if(ch1 != ch3){
                    answer.append(ch1);
                    i++;
                }
                else if(ch2!= ch3){
                    answer.append(ch2);
                    j++;
                }
            }

        }
        while(i < a){
            char ch1 = str1.charAt(i);
            answer.append(ch1);
            i++;
        }

        while(j < b){
            char ch1 = str2.charAt(j);
            answer.append(ch1);
            j++;
        }
        
        return answer.toString();

    }

    public String findLCS(String str1 , String str2){
        int i = str1.length();
        int j = str2.length();

        int[][] dp = new int[i+1][j+1];

        for(int k = 0 ; k < i+1 ; k++){
            dp[k][0] = 0;
        }
        for(int k = 0 ; k < j+1 ; k++){
            dp[0][k] = 0;
        }

        for(int k = 1 ; k< i+1 ; k++){
            for(int l =1 ;l < j+1 ; l++){
                char ch1 = str1.charAt(k-1);
                char ch2 = str2.charAt(l-1);

                if(ch1==ch2){
                    dp[k][l] = 1 + dp[k-1][l-1];

                }
                else{
                    dp[k][l] = Math.max(dp[k-1][l] , dp[k][l-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        while(i > 0 && j > 0){

            char ch1 = str1.charAt(i-1);
            char ch2 = str2.charAt(j-1);

            if(ch1==ch2){
                lcs.append(ch1);
                i--;
                j--;
            }
            else{
                if(dp[i][j] == dp[i-1][j]){
                    i--;
                }
                else{
                    j--;
                }
            }




        }
        return lcs.reverse().toString();
    }
}