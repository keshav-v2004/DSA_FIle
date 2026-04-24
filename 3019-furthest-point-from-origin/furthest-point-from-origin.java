class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        // go all in with L
        int left = 0;
        for(char ch : moves.toCharArray()){
            if(ch=='L' || ch == '_'){
                left++;
            }
            else{
                left--;
            }
        }

        // go all in with R
        int right = 0;
        for(char ch : moves.toCharArray()){
            if(ch=='R' || ch == '_'){
                right++;
            }
            else{
                right--;
            }
        }

        // find maximum
        int answer = Math.max(
            Math.abs(left) , Math.abs(right)
        );

        return answer;
    }
}