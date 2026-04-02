class Solution {
    public double myPow(double x, int n) {
        

        long nn = 1L * n;

        double answer = 1.0;

        if(n < 0){
            nn = -1*nn;

        }

        while(nn > 0){

            if(nn % 2 == 0){

                x = x*x;
                nn = nn/2;

            }
            else{

                answer = answer*x;
                nn = nn-1;
            }
        }

        if(n < 0){
            return (double) (1) / (double) (answer);
        }
        return answer;


    }
}