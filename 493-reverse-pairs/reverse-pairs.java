class Solution {

    public int count = 0;

    public int reversePairs(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {

        ArrayList<Integer> temp = new ArrayList<>();
        int low = left;
        int high = mid + 1;

        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - mid - 1);
        }

        while (low <= mid && high <= right) {

            if (nums[low] >= nums[high]) {
                temp.add(nums[high]);
                high++;
            } else {
                temp.add(nums[low]);
                low++;
            }
        }
        while (low <= mid) {
            temp.add(nums[low++]);
        }

        while (high <= right) {
            temp.add(nums[high++]);
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[i + left] = temp.get(i);
        }
        return;
    }
}