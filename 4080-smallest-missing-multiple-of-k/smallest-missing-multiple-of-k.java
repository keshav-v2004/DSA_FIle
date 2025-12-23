class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int elem : nums){
            set.add(elem);
        }


        int answer = k;
        int base = 2;
        while(true){
            if(!set.contains(answer)) return answer;
            
            else{
            answer = k * base;
            base++;
            }


        }
    }
}