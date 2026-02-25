class Solution {
    public int[] sortByBits(int[] arr) {

        Map<Integer , Integer> map = new HashMap<>();        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                if(map.get(a) != map.get(b)){
                    return Integer.compare(map.get(a) , map.get(b));
                }
                else{
                    return Integer.compare(a,b);
                }
            }
        );
        for(int elem : arr){
            map.put(elem , count(elem));
        }

        for(int elem : arr){
            pq.offer(elem);
        }
        int index = 0 ;
        while(!pq.isEmpty()){
            arr[index] = pq.poll();
            index++;
        }
        return arr;

    }

    public int count(int n){
        String binary = Integer.toBinaryString(n);

        int count = 0;
        for(char ch : binary.toCharArray()){
            if(ch=='1'){
                count++;
            }
        }
        return count;
    }
}