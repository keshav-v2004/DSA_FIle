class Solution {
    public boolean uniformArray(int[] nums1) {

        
        int minOdd= Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int elem : nums1) {
            

            if(elem % 2 != 0){
                minOdd = Math.min(minOdd , elem);
            }
            else{
                minEven = Math.min(minEven , elem);

            }
        }
        if(minOdd == Integer.MAX_VALUE || minEven == Integer.MAX_VALUE){
            return true;
        }

        boolean allEven = true;
        int n = nums1.length;

        for (int i = 0; i < n; i++) {

            int elem = nums1[i];

            if (elem % 2 == 0) {
                continue;
            }

            boolean byOp2 = false;

            if(elem - minOdd >= 1){
                byOp2 = true;
            }

            if (byOp2 == false) {
                allEven = false;
                break;
            }
        }

        boolean allOdd = true;
        for (int i = 0; i < n; i++) {

            int elem = nums1[i];

            if (elem % 2 != 0) {
                continue;
            }

            boolean byOp2 = false;

            if(elem - minOdd >= 1){
                byOp2 = true;

            }
            if (byOp2 == false) {
                allOdd = false;
                break;
            }
        }
        return allEven || allOdd;


    }
}