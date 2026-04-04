class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;
        if(n % groupSize != 0) return false;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        

        for(int elem : hand){
            pq1.offer(elem);
        }

        Set<Integer> set = new HashSet<>();

        while(!pq1.isEmpty()){
            
            int cur = pq1.poll();

            if(set.isEmpty()){
                set.add(cur);

                if(set.size() == groupSize){
                    set.clear();
                    while(!pq2.isEmpty()){
                        pq1.offer(pq2.poll());
                    }
                }
            }
            else{
                if(set.contains(cur)){
                    pq2.offer(cur);
                }

                else if(set.contains(cur - 1)){
                    set.add(cur);
                    if(set.size() == groupSize){
                        set.clear();
                        while(!pq2.isEmpty()){
                            pq1.offer(pq2.poll());
                        }
                    }
                }
                else{
                    return false;
                }
            }

        }

        return set.isEmpty();

    }
}