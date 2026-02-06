class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs , (a,b) ->{
            return Integer.compare(a[1] , b[1]);
        });


        int max = 1;
        int n = pairs.length;
        
        for(int i = 0 ; i<n ; i++){
            int prev = pairs[i][1];
            int chain = 0;

            for(int j = i ; j < n ; j++){

                int elem = pairs[j][0];

                if(elem > prev){
                    chain++;
                    prev = pairs[j][1];
                }

            }
            chain++;
            max = Math.max(max , chain);
        }



        return max;
    }
}