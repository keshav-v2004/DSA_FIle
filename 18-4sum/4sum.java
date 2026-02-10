class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        if (n < 4) return answer;

        Arrays.sort(nums);

        Set<List<Integer>> quads = new HashSet<>();

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {

                int low = j + 1;
                int high = n - 1;

                long newTarget = (long) target - nums[i] - nums[j];

                while (low < high) {
                    long sum = (long) nums[low] + nums[high];

                    if (sum == newTarget) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[low]);
                        quad.add(nums[high]);

                        quads.add(quad);

                        low++;
                        high--;
                    } 
                    else if (sum < newTarget) {
                        low++;
                    } 
                    else {
                        high--;
                    }
                }
            }
        }

        answer.addAll(quads);
        return answer;
    }
}
