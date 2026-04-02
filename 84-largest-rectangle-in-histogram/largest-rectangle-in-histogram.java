class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // find pse
        for(int i = 0 ; i < n ; i++){

            if(stack.isEmpty()){
                pse[i] = -1;
                stack.push(i);
            }

            else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    pse[i] = -1;
                    stack.push(i);

                }
                else{
                    pse[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        stack = new Stack<>();
        // find nse
        for(int i = n-1 ; i >= 0 ; i--){

            if(stack.isEmpty()){
                nse[i] = n;
                stack.push(i);
            }

            else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nse[i] = n;
                    stack.push(i);

                }
                else{
                    nse[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){

            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea , area);

        }
        return maxArea;
    }
}