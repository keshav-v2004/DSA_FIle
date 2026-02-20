import java.util.*;

class Solution {
    public int calculate(String s) {

        List<String> postfix = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        int n = s.length();
        int i = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        StringBuilder number = new StringBuilder();

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                i++;
            }
            else if (Character.isDigit(ch)) {
                number.append(ch);
                i++;
            }
            else {

                if (number.length() > 0) {
                    postfix.add(number.toString());
                    number.setLength(0);
                }

                while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch)) {
                    postfix.add(String.valueOf(stack.pop()));
                }

                stack.push(ch);
                i++;
            }
        }

        if (number.length() > 0) {
            postfix.add(number.toString());
        }

        while (!stack.isEmpty()) {
            postfix.add(String.valueOf(stack.pop()));
        }

        Stack<Integer> eval = new Stack<>();

        for (String str : postfix) {

            if (!str.equals("+") && !str.equals("-") &&
                !str.equals("*") && !str.equals("/")) {

                eval.push(Integer.parseInt(str));
            }
            else {
                int first = eval.pop();
                int second = eval.pop();

                int result = 0;

                if (str.equals("+")) {
                    result = second + first;
                }
                else if (str.equals("-")) {
                    result = second - first;
                }
                else if (str.equals("*")) {
                    result = second * first;
                }
                else if (str.equals("/")) {
                    result = second / first;
                }

                eval.push(result);
            }
        }

        return eval.pop();
    }
}