class Solution {
    public long removeZeros(long n) {
        
        StringBuilder answer = new StringBuilder();

        String number = String.valueOf(n);

        for(char ch : number.toCharArray()){
            if(ch!= '0'){
                answer.append(ch);

            }

        }
        return Long.parseLong(answer.toString());


    }
}