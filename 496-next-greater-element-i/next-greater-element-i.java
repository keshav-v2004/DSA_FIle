class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] answer = new int[nums1.length];
        int[] nge  =new int[nums2.length];

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums2.length ; i++){

            map.put(nums2[i] , i);

        }

        Stack<Integer> stack = new Stack<>();
        int index = nums2.length-1;

        for(int i = nums2.length-1 ; i>= 0 ; i--){

            int elem = nums2[i];

            if(stack.isEmpty()){
                nge[index] = -1;
                stack.push(elem);
            }

            else if(stack.peek() <= elem){
                while(!stack.isEmpty() && stack.peek() <= elem){
                    stack.pop();

                }
                if(stack.isEmpty()){
                    nge[index] = -1;
                    stack.push(elem);
                }
                else{
                    nge[index] = stack.peek();
                    stack.push(elem);
                }
            }
            else{
                nge[index] = stack.peek();
                stack.push(elem);
            }
            index--;
        }
        int i= 0;

        for(int elem : nums1){
            index = map.get(elem);
            answer[i] = nge[index];

            i++;

        }

        return answer;
    }
}