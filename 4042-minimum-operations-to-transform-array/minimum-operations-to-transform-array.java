class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int lastElem = nums2[n]; 
        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += Math.abs((long)nums1[i] - nums2[i]);
        }

        long extraDist = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((lastElem >= nums1[i] && lastElem <= nums2[i]) || 
                (lastElem <= nums1[i] && lastElem >= nums2[i])) {
                extraDist = 0;
                break; 
            }

            long d1 = Math.abs((long)nums1[i] - lastElem);
            long d2 = Math.abs((long)nums2[i] - lastElem);
            extraDist = Math.min(extraDist, Math.min(d1, d2));
        }

        return answer + extraDist + 1;
    }
}