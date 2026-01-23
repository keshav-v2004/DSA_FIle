class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        int l = 0;
        int r = 0;
        int n = s.length();

        while (r < n) {

            char ch = s.charAt(r);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            while (true) {

                boolean isSubset = true;
                for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {

                    char key = entry.getKey();
                    int freq = entry.getValue();

                    if (!sMap.containsKey(key) || sMap.get(key) < freq) {
                        isSubset = false;
                        break;
                    }
                }

                if (!isSubset) break;

                int len = r - l + 1;
                if (len < minLength) {
                    minLength = len;
                    start = l;
                    end = r;
                }

                char leftChar = s.charAt(l);
                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if (sMap.get(leftChar) == 0) {
                    sMap.remove(leftChar);
                }

                l++;
            }

            r++;
        }

        if (start == -1) return "";
        return s.substring(start, end + 1);
    }
}
