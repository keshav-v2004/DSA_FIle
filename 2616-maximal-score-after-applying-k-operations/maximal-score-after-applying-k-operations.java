class Solution {
    public long maxKelements(int[] nums, int k) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int elem : nums) {
            pq.offer(elem);
        }

        while (k > 0) {
            long elem = pq.poll();
            answer += elem;

            pq.offer((int) ((elem + 2) / 3));

            k--;
        }
        return answer;

    }
}