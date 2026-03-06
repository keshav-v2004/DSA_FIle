class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;

        int n = s.length();

        int maxLen = 0;

        while(r < n){
            char ch = s.charAt(r);

            if(!set.contains(ch)){
                set.add(ch);
                maxLen = Math.max(maxLen , r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return maxLen;
    }
}