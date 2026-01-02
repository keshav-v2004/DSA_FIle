class Solution {
    public int commonFactors(int a, int b) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 1 ; i <=a ; i++ ){
            if(a % i ==0){
                set.add(i);
            }
        }
        for(int i = 1 ; i<= b ; i++){
            if(b % i ==0 && set.contains(i)){
                count++;
            }
        }
        return count;
    }
}