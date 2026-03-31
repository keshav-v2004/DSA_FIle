class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int val = num.charAt(i) - '0';

            while (k > 0 && !stack.isEmpty() && stack.peek() > val) {
                stack.pop();
                k--;
            }

            stack.push(val);
        }

        // remove remaining k digits
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // build result
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        answer.reverse();

        // remove leading zeros
        while (answer.length() > 1 && answer.charAt(0) == '0') {
            answer.deleteCharAt(0);
        }

        return answer.toString();
    }
}