class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int decreaseBy = 0;
        long sum =0;
        int selected = 0;
        for(int i = happiness.length-1 ; i>= 0 ; i--){
            if(selected==k){
                break;
            }
            int val = happiness[i] - decreaseBy;
            if(val > 0){
                selected++;
                sum+=val;
                decreaseBy++;
            }
        }   
        return sum;
    }
}