class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int elem : nums){
            pq.offer(elem);
        }
        int index = 0;
        while(!pq.isEmpty()){
            nums[index] = pq.poll();
            index++;
        }
        return nums;
    }
}