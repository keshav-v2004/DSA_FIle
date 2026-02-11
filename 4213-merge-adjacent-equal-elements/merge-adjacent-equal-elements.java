class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        
        Stack<Long> stack = new Stack();

        for(long elem : nums){

            if(stack.isEmpty() || stack.peek() != elem){
                stack.push(elem);
            }

            else if(elem == stack.peek()){
                long x = elem;

                while(!stack.isEmpty() && x==stack.peek()){
                    x += stack.pop();
                }
                stack.push(x);
            }
        }

        List<Long> answer = new ArrayList<>();

        while(!stack.isEmpty()){
            answer.add(0 , stack.pop());
        }
        return answer;
    }
}