class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int elem : nums) {
            set.add(elem);
        }

        int maxLen = 0;

        for (int elem : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(elem - 1)) {
                int curr = elem;
                int len = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
