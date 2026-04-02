class Solution {

    ArrayList<String> answer = new ArrayList<>();

    public String getPermutation(int n, int k) {

        int[] hash = new int[n+1];

        helper(new StringBuilder() , hash , n);

        return answer.get(k-1);


        

    }

    public void helper(StringBuilder each , int[] hash , int n){

        boolean found = false;

        for(int i = 1 ; i <= n ; i++){
            
            if(hash[i] == 0){

                found = true;
                hash[i] = 1;
                each.append(i);

                helper(each , hash , n);

                hash[i] = 0;
                each.deleteCharAt(each.length()-1);

            }
        }

        if(found == false){

            answer.add(new StringBuilder(each).toString());

        }
    }
}