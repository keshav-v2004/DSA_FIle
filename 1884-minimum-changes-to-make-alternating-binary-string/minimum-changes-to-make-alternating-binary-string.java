class Solution {
    public int minOperations(String s) {
        
        int startZero = 0;
        int startOne = 0;

        boolean zeroExpected = true;
        boolean oneExpected = true;
        
        for(char ch : s.toCharArray()){

            if(zeroExpected==true){
                if(ch=='1'){
                    startZero++;
                }
            }
            else{
                if(ch=='0'){
                    startZero++;
                }
            }
            zeroExpected = !zeroExpected;
        }
        
        for(char ch : s.toCharArray()){

            if(oneExpected==true){
                if(ch=='0'){
                    startOne++;
                }
            }
            else{
                if(ch=='1'){
                    startOne++;
                }
            }
            oneExpected = !oneExpected;
        }
        return Math.min(startOne , startZero);
        
    }
}