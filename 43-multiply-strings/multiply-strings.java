class Solution {
    public String multiply(String num1, String num2) {
        int[] answer = new int[num1.length() + num2.length()];

        int index = 0;
        int mover = 0;
        int carry = 0;
        int n1 = num1.length();
        int n2 = num2.length();

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int total = digit1*digit2 + answer[mover] + carry;
                answer[mover] = total % 10 ;
                carry = total / 10;
                mover++;
            }
            if(carry > 0){
                answer[mover]+=carry;
            }
            index++;
            mover = index;
            carry = 0;
        }

        StringBuilder output = new StringBuilder();
        boolean isLeadingZero = true;
        

        for (int i = answer.length - 1; i >= 0; i--) {
            if (answer[i] == 0) {
                if (isLeadingZero) continue;
            } else {
                isLeadingZero = false;
            }
            if (!isLeadingZero) {
                output.append(answer[i]);
            }
        }
        return output.length() == 0 ? "0" : output.toString();
    }
}