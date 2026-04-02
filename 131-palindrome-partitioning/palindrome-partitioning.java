class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(0,s,new ArrayList<>());

        return answer;
    }

    public void helper( int index , String s , List<String> each){

        int n = s.length();

        if(index == n){
            answer.add(new ArrayList<>(each));
            return;
        }

        for(int k = index ; k < n ; k++){

            String substr = s.substring(index , k+1);
            if(isPalindrome(substr)){
                each.add(substr);

                helper(k+1 , s,each);

                each.remove(each.size()-1);

            }
        }
    }

    public boolean isPalindrome(String s){

        int l = 0;
        int r = s.length()-1;

        while(l < r){
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);

            if(ch1 != ch2){
                return false;
            }
            else{
                l++;
                r--;
            }
        }

        return true;
    }
}