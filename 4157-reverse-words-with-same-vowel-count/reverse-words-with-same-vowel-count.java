class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");

        String first = words[0];

        int vowelCount = 0;

        for(char ch : first.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowelCount++;
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(first);
        answer.append(" ");

        for(int i = 1 ; i < words.length ; i++){
            if(helper(vowelCount , words[i])){
                answer.append(new StringBuilder(words[i]).reverse().toString());
                answer.append(" ");
            }
            else{
                answer.append(words[i]);
                answer.append(" ");   
            }
        }

        answer.deleteCharAt(answer.length()-1);
        return answer.toString();

    }

    boolean helper(int target , String s){
        int count = 0;

        for(char ch : s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        }

        if(count==target) return true;

        return false;
    }
}