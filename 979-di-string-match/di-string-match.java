class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();

        int start = 0;
        int end = n;

        int[] perm = new int[n+1];
        int[] hash = new int[n+1];

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i)=='I'){
                perm[i] = start;
                hash[start] = 1;
                start++;
                
            }
            else{
                perm[i] = end;
                hash[end] = 1;
                end--;
                
            }
        }
        for(int i = 0 ; i < hash.length ; i++){
            if(hash[i]==0){
                perm[n] = i;
                break;
            }
        }
        return perm;

    }
}