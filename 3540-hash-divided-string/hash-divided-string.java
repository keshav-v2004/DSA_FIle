class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();

        int start = 0;
        int end = k;
        int n = s.length();

        while(start < n){

            String each = s.substring(start , end);
            int answer = findTotal(each);
            int hashedChar = answer % 26;

            char alphabet = (char) (hashedChar + (int)'a');

            result.append(alphabet);
            start+=k;
            end = end + k;

        }
        return result.toString();
    }

    public int findTotal(String each){
        int answer = 0;

        for(char ch : each.toCharArray()){
            answer+=ch-'a';
        }
        return answer;
    }
}