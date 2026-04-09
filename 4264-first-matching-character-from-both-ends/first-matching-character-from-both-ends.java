class Solution {
    public int firstMatchingIndex(String s) {
        
        int l = 0;
        int r = s.length()-1;

        int answer = -1;

        while(l <= r){
            if(s.charAt(l) == s.charAt(r)){
                answer = l;
                break;
            }
            l++;
            r--;
        }
        return answer;
    }
}