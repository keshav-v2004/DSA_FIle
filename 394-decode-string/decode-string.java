import java.util.Stack;

class Solution {
    public int index = 0;

    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        return helper(s, stack).toString();
    }

    public StringBuilder helper(String s, Stack<Integer> stack) {
        StringBuilder temp = new StringBuilder();

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {

                String freq = "";
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    freq += s.charAt(index);
                    index++;
                }
                stack.push(Integer.parseInt(freq));

            } else if (ch == '[') {
                index++; 
                
                temp.append(helper(s, stack));

            } else if (ch == ']') {
                index++; 
                int count = stack.pop(); 
                StringBuilder rep = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    rep.append(temp);
                }
                return rep; 

            } else { 
                temp.append(ch);
                index++;
            }
        }

        return temp;
    }
}
