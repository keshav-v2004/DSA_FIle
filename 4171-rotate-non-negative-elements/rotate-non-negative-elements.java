class Solution {
    public int[] rotateElements(int[] nums, int k) {
        if (k == 0)
            return nums;

        ArrayList<Integer> non = new ArrayList<>();

        for (int elem : nums) {
            if (elem >= 0) {
                non.add(elem);
            }
        }
        if (non.isEmpty())
            return nums;

        rotate(non, k);

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = non.get(index);
                index++;
            }
        }
        return nums;

    }

    public void rotate(ArrayList<Integer> non, int k) {
        int n = non.size();
        k = k % n;

        // reverse 0 --> k-1
        reverse(non, 0, k - 1);

        // reverse k --> n-1
        reverse(non, k, n - 1);

        // reverse entire array
        reverse(non, 0, n - 1);
    }

    public void reverse(ArrayList<Integer> list, int i, int j) {
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

}