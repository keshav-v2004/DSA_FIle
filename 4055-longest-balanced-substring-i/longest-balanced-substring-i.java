import java.util.*;
class Solution {
    public int longestBalanced(String s) {
        
        int maxLen = 1;
        int n = s.length();

        for(int i = 0 ; i < n ; i++){

            Map<Character , Integer> map = new HashMap<>();

            char ch = s.charAt(i);
            map.put(ch , 1);

            for(int j = i+1 ; j < n ; j++){
                char ch2 = s.charAt(j);

                map.put(ch2 , map.getOrDefault(ch2,0)+1);

                if (new HashSet<>(map.values()).size() == 1) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;

    }
}