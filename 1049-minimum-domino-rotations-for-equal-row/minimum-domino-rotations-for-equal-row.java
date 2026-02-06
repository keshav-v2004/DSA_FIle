class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int elem : tops) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        for (int elem : bottoms) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        

        int elem = -1;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                elem = val;
            }
        }
        // check for top
        int top = 0;

        for(int i = 0 ; i < tops.length ; i++){
            int t = tops[i];
            int b = bottoms[i];

            if(t==elem) continue;

            else{
                if(b != elem){
                    top = -1;
                    break;
                }
                else{
                    top++;
                }
            }
        }

        // check for bottom
        int bottom = 0;
        for(int i = 0 ; i < tops.length ; i++){
            int t = tops[i];
            int b = bottoms[i];

            if(b==elem) continue;

            else{
                if(t != elem){
                    bottom = -1;
                    break;
                }
                else{
                    bottom++;
                }
            }
        }

        if(top != -1 && bottom != -1){
            return Math.min(top, bottom);
        }
        if(top==-1) return bottom;
        return top;
    }
}