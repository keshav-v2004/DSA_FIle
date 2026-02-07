class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> answer = new ArrayList<>();

        Set<String> repeating = new HashSet<>();
        Set<String> inAnswer = new HashSet<>();

        int r = 0;
        int n = s.length();
        StringBuilder each = new StringBuilder();

        while(r < 10 && r < n){
            char ch = s.charAt(r);

            each.append(ch);
            r++;

        } 
        if(each.length() < 10){
            return answer;
        }
        repeating.add(each.toString());

        while(r < n){
            char ch = s.charAt(r);

            each.append(ch);
            each.deleteCharAt(0);

            if(repeating.contains(each.toString())){
                if(!inAnswer.contains(each.toString())){
                    inAnswer.add(each.toString());
                }
            }
            else{
                repeating.add(each.toString());
            }
            r++;
        }
        for(String elem : inAnswer){
            answer.add(elem);
        }
        return answer;
    }
}