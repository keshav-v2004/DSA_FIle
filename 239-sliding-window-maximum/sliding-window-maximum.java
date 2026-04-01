class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> answer = new ArrayList<>();

        int l = 0;
        int r = 0;
        int n = nums.length;

        ArrayDeque<Integer> adq = new ArrayDeque<>();

        while(r < k){

            while(!adq.isEmpty() && nums[adq.peekLast()] <= nums[r]){
                adq.pollLast();
            }
            adq.offerLast(r);
            r++;
        }
        answer.add(nums[adq.peekFirst()]);
        
        while(r < n){

            l++;

            // remove out of window elements
            while( !adq.isEmpty() && adq.peekFirst() < l){
                adq.pollFirst();
            }

            // Maintain monotonic deque
            while(!adq.isEmpty() && nums[adq.peekLast()] <= nums[r]){
                adq.pollLast();
            }

            adq.offerLast(r);

            answer.add(nums[adq.peekFirst()]);
            r++;


        }

        int[] output = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++){
            output[i] = answer.get(i);
        }
        return output;
    }
}