class Solution {
    public int[] separateDigits(int[] nums) {
        
        ArrayList<Integer> answer = new ArrayList<>();

        for(int elem : nums){

            helper(elem , answer);
        }

        int[] output = new int[answer.size()];

        for(int i = 0 ; i < answer.size() ; i++){
            output[i] = answer.get(i);

        }
        return output;
    }

    public void helper(int num , ArrayList<Integer> arr){

        ArrayList<Integer> temp = new ArrayList<>();

        while(num > 0){
            int digit = num % 10 ;

            temp.add(digit);

            num = num / 10;
        }

        Collections.reverse(temp);

        for(int elem : temp){
            arr.add(elem);
        }


    }
}