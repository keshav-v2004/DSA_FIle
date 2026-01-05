class Solution {
    public int countTriples(int n) {
        int answer = 0;

        for(int i = 1 ; i<= n ; i++){
            int a = i;

            for(int j = 1 ; j <= n ; j++){

                int b = j;

                for(int k = 1 ; k<= n ; k++){

                    int c = k;

                    if(
                        (a*a + b*b) == (c*c)
                    ){
                        answer++;
                    }

                }
            }
        }
        return answer;
    }
}