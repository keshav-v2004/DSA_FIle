class Solution {
    public String countAndSay(int n) {
        
        return helper(n);

    }

    public String helper(int n){
        if(n==1) return "1";

        String res = helper(n-1);

        int i = 1;
        int count = 1;
        char prev = res.charAt(0);

        StringBuilder answer = new StringBuilder();
        while(i < res.length()){
            char cur = res.charAt(i);
            if(cur==prev){
                count++;
            }
            else{
                answer.append(count);
                answer.append(prev);
                count = 1;
                prev = cur;
            }
            i++;
        }
        answer.append(count);
        answer.append(prev);

        return answer.toString();
    }


}