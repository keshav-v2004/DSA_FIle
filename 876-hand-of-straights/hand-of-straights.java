class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;
        if (n % groupSize != 0) return false;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int elem : hand) {
            pq1.offer(elem);
        }

        List<Integer> group = new ArrayList<>();

        while (!pq1.isEmpty()) {

            int cur = pq1.poll();

            if (group.isEmpty()) {
                group.add(cur);
            } 
            else {
                int last = group.get(group.size() - 1);

                if (cur == last) {
                    // duplicate → delay
                    pq2.offer(cur);
                    continue;
                } 
                else if (cur == last + 1) {
                    group.add(cur);
                } 
                else {
                    return false;
                }
            }

            // group complete
            if (group.size() == groupSize) {
                group.clear();

                // push back skipped elements
                while (!pq2.isEmpty()) {
                    pq1.offer(pq2.poll());
                }
            }
        }

        return group.isEmpty(); 
    }
}