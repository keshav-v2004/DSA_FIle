class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] answer = new int[nums.length];

        Stack<Integer> stack = new Stack<>();


        for(int i = 2*nums.length-1 ; i >= 0  ; i--){

            int index = i%nums.length;

            int elem = nums[index];

            if(stack.isEmpty()){
                answer[index] = -1;
                stack.push(elem);
            }

            else if(stack.peek() <= elem){
                while(!stack.isEmpty() && stack.peek() <= elem){
                    stack.pop();

                }
                if(stack.isEmpty()){
                    answer[index] = -1;
                    stack.push(elem);
                }
                else{
                    answer[index] = stack.peek();
                    stack.push(elem);
                }
            }
            else{
                answer[index] = stack.peek();
                stack.push(elem);
            }
        }   
        
        return answer;
    }
}