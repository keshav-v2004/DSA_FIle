class Solution {
    public int countBinarySubstrings(String s) {
        
        char prev = s.charAt(0);
        int c = 1;

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 1 ; i < s.length() ; i++){
            char cur = s.charAt(i);

            if(cur==prev){
                c++;
            }
            else{
                answer.add(c);
                c = 1;
                prev = cur;
            }
        }
        answer.add(c);
        int count = 0;
        for(int i = 0 ; i < answer.size()-1 ; i++){
            count += Math.min(answer.get(i) , answer.get(i+1));
        }
        return count;
    }
}