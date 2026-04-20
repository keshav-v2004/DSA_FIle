class Solution {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;


        int n = colors.length;

        for(int i = 0 ; i  < n ; i++){

            for(int j = 0 ; j < n ; j++){

                if(i != j && colors[i] != colors[j]){
                    int distance = Math.abs(j-i);

                    max = Math.max(max , distance);
                }
            }
        } 
        return max;
    }
}