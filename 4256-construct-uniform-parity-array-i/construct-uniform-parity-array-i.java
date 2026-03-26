class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean isEvenPossible = true;

        // agar ek bhi operation karke even element nahi aaya --> cannot construct even 
        int n = nums1.length;

        for (int i = 0; i < n; i++) {

            int elem = nums1[i];

            if (elem % 2 == 0) {
                continue;
            }

            boolean byOp2 = false;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                int x = nums1[i] - nums1[j];

                if (x % 2 == 0) {
                    byOp2 = true;
                    break;
                }
            }
            if (byOp2 == false) {
                isEvenPossible = false;
                break;
            }

        }
        boolean isOddPossible = true;
        for (int i = 0; i < n; i++) {

            int elem = nums1[i];

            if (elem % 2 != 0) {
                continue;
            }

            boolean byOp2 = false;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                int x = nums1[i] - nums1[j];

                if (x % 2 != 0) {
                    byOp2 = true;
                    break;
                }
            }
            if (byOp2 == false) {
                isOddPossible = false;
                break;
            }
        }
        return isEvenPossible || isOddPossible;

    }
}