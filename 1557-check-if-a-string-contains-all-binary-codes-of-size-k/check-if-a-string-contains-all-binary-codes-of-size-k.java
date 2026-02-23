class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        int l = 0;
        int r = 0;

        int n = s.length();

        StringBuilder each = new StringBuilder();

        while(r < n && r < k){
            each.append(s.charAt(r));
            r++;
        }
        set.add(each.toString());

        while(r < n){
            each.append(s.charAt(r));
            r++;
            each.deleteCharAt(0);
            l++;

            set.add(each.toString());
        }   
        int answer = (int) Math.pow(2,k);

        return set.size() == answer;
    }
}