class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] first = helper(num1);
        int[] second = helper(num2);

        int a = first[0], b = first[1];
        int c = second[0], d = second[1];

        int real = a * c - b * d;
        int complex = a * d + b * c;

        return real + "+" + complex + "i";
    }

    public int[] helper(String num) {

        boolean realNeg = false;
        boolean complexNeg = false;

        int index = 0;
        int n = num.length();

        StringBuilder realString = new StringBuilder();
        StringBuilder complexString = new StringBuilder();

        if (num.charAt(index) == '-') {
            realNeg = true;
            index++;
        } else if (num.charAt(index) == '+') {
            index++;
        }

        while (index < n && num.charAt(index) != '+') {
            realString.append(num.charAt(index));
            index++;
        }

        index++;

        if (num.charAt(index) == '-') {
            complexNeg = true;
            index++;
        }

        while (index < n && num.charAt(index) != 'i') {
            complexString.append(num.charAt(index));
            index++;
        }

        int real = Integer.parseInt(realString.toString());
        if (realNeg)
            real *= -1;

        int complex = Integer.parseInt(complexString.toString());
        if (complexNeg)
            complex *= -1;

        return new int[] { real, complex };
    }

}