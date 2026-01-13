class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            return (b+a).compareTo(a+b);
        });

        for(int elem : nums){
            pq.offer( Integer.toString(elem));
        }
        StringBuilder answer = new StringBuilder();

        if(pq.peek().equals("0")) return "0";

        while(!pq.isEmpty()){
            answer.append(pq.poll());
        }
        return answer.toString();
    }
}