class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] prevLarger = new int[n];
        int[] nextLarger = new int[n];

        prevLarger[0] = height[0];
        nextLarger[n-1] = height[n-1];

        for(int i = 1 ; i < n ; i++){
            prevLarger[i] = Math.max(prevLarger[i-1] , height[i]);
        }

        for(int i = n-2 ; i >= 0 ; i--){
            nextLarger[i] = Math.max(nextLarger[i+1] , height[i]);
        }

        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            int leftMax = prevLarger[i];
            int rightMax = nextLarger[i];

            int cur = height[i];

            if(leftMax != -1 && rightMax != -1 && leftMax > cur && rightMax > cur){
                answer += Math.min(leftMax , rightMax) - cur;
            }
        }
        return answer;
    }
}