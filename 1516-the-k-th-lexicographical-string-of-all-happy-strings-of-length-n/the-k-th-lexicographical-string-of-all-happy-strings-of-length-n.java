class Solution {

    public ArrayList<String> allPossible = new ArrayList<>();

    public String getHappyString(int n, int k) {
        
        helper(n , "");

        if(allPossible.size() < k){
            return "";
        }

        return allPossible.get(k-1);
        
    }

    public void helper(int n , String prev){

        if(prev.length()==n){
            allPossible.add(prev);
            return;
        }

        for(int i = 0 ; i < 3 ; i++){

            int val = i + 97;
            char ch = (char)val;

            if(prev.isEmpty()){
                
                helper(n , prev+String.valueOf(ch));
            }

            else if(!prev.isEmpty() && prev.charAt(prev.length()-1) != ch){
                helper(n , prev+String.valueOf(ch));
            }
        }
    }
}