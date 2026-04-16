class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int n = nums.length;

        // Build map
        for(int i = 0 ; i < n ; i++){
            int elem = nums[i];
            map.putIfAbsent(elem , new ArrayList<>());
            map.get(elem).add(i);
        }

        for(int index : queries){

            int elem = nums[index];
            List<Integer> indices = map.get(elem);

            // If only one occurrence
            if(indices.size() == 1){
                answer.add(-1);
                continue;
            }

            int low = 0;
            int high = indices.size() - 1;

            int pos = -1;

            // Binary search to find position of index
            while(low <= high){
                int mid = (low + high) / 2;

                if(indices.get(mid) == index){
                    pos = mid;
                    break;
                }
                else if(indices.get(mid) < index){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }

            // neighbors (circular in list)
            int left = (pos - 1 + indices.size()) % indices.size();
            int right = (pos + 1) % indices.size();

            int leftIdx = indices.get(left);
            int rightIdx = indices.get(right);

            int d1 = Math.abs(index - leftIdx);
            int d2 = Math.abs(index - rightIdx);

            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);

            answer.add(Math.min(dist1, dist2));
        }

        return answer;
    }
}