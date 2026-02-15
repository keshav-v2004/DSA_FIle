class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder temp = new StringBuilder();
        int carry = 0;


        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (carry == 0) {
                    temp.append('0');
                } else {
                    temp.append('1');
                    carry = 0;
                }
            } else if (
                    (a.charAt(i) == '1' && b.charAt(j) == '0') ||
                            (a.charAt(i) == '0' && b.charAt(j) == '1')
            ) {
                if (carry == 0) {
                    temp.append('1');
                } else {
                    temp.append('0');
                    carry = 1;
                }
            } else { // both are '1'
                if (carry == 0) {
                    temp.append('0');
                    carry = 1;
                } else {
                    temp.append('1');
                    carry = 1;
                }
            }
            i--;
            j--;
        }

       
        while (i >= 0) {
            if (a.charAt(i) == '0') {
                if (carry == 0) {
                    temp.append('0');
                } else {
                    temp.append('1');
                    carry = 0;
                }
            } else {
                if (carry == 0) {
                    temp.append('1');
                } else {
                    temp.append('0');
                    carry = 1;
                }
            }
            i--;
        }

        
        while (j >= 0) {
            if (b.charAt(j) == '0') {
                if (carry == 0) {
                    temp.append('0');
                } else {
                    temp.append('1');
                    carry = 0;
                }
            } else { 
                if (carry == 0) {
                    temp.append('1');
                } else {
                    temp.append('0');
                    carry = 1;
                }
            }
            j--;
        }

        
        if (carry == 1) {
            temp.append('1');
        }

        return temp.reverse().toString();
    }
}