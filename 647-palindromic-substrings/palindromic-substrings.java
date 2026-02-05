class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int[] answer = new int[n];
        Arrays.fill(answer , 1);

        for(int i = 1 ; i < n ; i++){

            for(int j = i-1 ; j >= 0 ; j--){
                if(checkPalindrome(j , i , s)){
                    answer[i]++;
                }
            }
        }
        int count = 0;
        for(int elem : answer){
            count+=elem;
        }
        return count;
    }

    boolean checkPalindrome(int start , int end , String s){
        while(start <= end){
            char ch1 = s.charAt(start);
            char ch2 = s.charAt(end);

            if(ch1 != ch2){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}