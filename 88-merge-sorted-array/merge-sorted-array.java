class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int k = nums1.length-1;

        int j = nums2.length-1;

        while(i >= 0 && j >= 0){

            int elem1 = nums1[i];
            int elem2 = nums2[j];

            if(elem1 < elem2){
                nums1[k] = elem2;
                k--;
                j--;
            }
            else{
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }

        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }

    }
}