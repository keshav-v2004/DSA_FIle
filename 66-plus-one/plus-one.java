class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        ArrayList<Integer> answer = new ArrayList<>();

        int carry = 1;

        for(int i = n-1 ; i>= 0 ; i--){
            if(carry > 0){
                int total = digits[i] + carry;
                carry = total / 10;
                answer.add(0 , total % 10);
            }
            else{
                answer.add(0 , digits[i]);
            }
        }

        if(carry > 0){
            answer.add(0 , 1);
        }
        int[] output = new int[answer.size()];

        for(int i = 0 ; i < answer.size() ; i++){
            output[i] = answer.get(i);
        }
        return output;



    }
}