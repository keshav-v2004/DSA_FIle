class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();

        int[] nextSmaller = new int[n];
        int[] prevSmallerOrEqual = new int[n];

        // next strictly smaller
        for(int i = n-1 ; i >= 0 ; i-- ){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }


        stack.clear();

        // previous smaller or equal
        for(int i = 0 ; i < n ; i++ ){

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            prevSmallerOrEqual[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int total = 0;
        int mod = (int)1e9 + 7;

        for(int i = 0 ; i < n ; i++){
            int left = i - prevSmallerOrEqual[i];
            int right = nextSmaller[i] - i;

            long contribution = (long)left * right * arr[i];
            total = (int)((total + contribution % mod) % mod);
        }

        return total;
    }
}