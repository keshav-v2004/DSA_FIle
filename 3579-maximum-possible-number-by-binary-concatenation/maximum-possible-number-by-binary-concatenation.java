class Solution {
    public int maxGoodNumber(int[] nums) {
        int max = 0;

        if (Integer.toBinaryString(nums[0]).charAt(0) == '1') {
            String str1 = Integer.toBinaryString(nums[0]) +
                          Integer.toBinaryString(nums[1]) +
                          Integer.toBinaryString(nums[2]);

            String str2 = Integer.toBinaryString(nums[0]) +
                          Integer.toBinaryString(nums[2]) +
                          Integer.toBinaryString(nums[1]);

            max = Math.max(
                max,
                Math.max(
                    Integer.parseInt(str1, 2),
                    Integer.parseInt(str2, 2)
                )
            );
        }

        if (Integer.toBinaryString(nums[1]).charAt(0) == '1') {
            String str1 = Integer.toBinaryString(nums[1]) +
                          Integer.toBinaryString(nums[0]) +
                          Integer.toBinaryString(nums[2]);

            String str2 = Integer.toBinaryString(nums[1]) +
                          Integer.toBinaryString(nums[2]) +
                          Integer.toBinaryString(nums[0]);

            max = Math.max(
                max,
                Math.max(
                    Integer.parseInt(str1, 2),
                    Integer.parseInt(str2, 2)
                )
            );
        }

        if (Integer.toBinaryString(nums[2]).charAt(0) == '1') {
            String str1 = Integer.toBinaryString(nums[2]) +
                          Integer.toBinaryString(nums[0]) +
                          Integer.toBinaryString(nums[1]);

            String str2 = Integer.toBinaryString(nums[2]) +
                          Integer.toBinaryString(nums[1]) +
                          Integer.toBinaryString(nums[0]);

            max = Math.max(
                max,
                Math.max(
                    Integer.parseInt(str1, 2),
                    Integer.parseInt(str2, 2)
                )
            );
        }

        return max;
    }
}
