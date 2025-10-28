import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        int i = 0;
        while (i < n) {

            int first = nums[i];
            if (first > 0) break;

            int low = i + 1;
            int high = n - 1;

            int second;
            int third;

            boolean found = false;
            while (low < high) {

                second = nums[low];
                third = nums[high];

                if (first + second + third == 0) {

                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(first);
                    triplet.add(second);
                    triplet.add(third);

                    answer.add(triplet);
                    found = true;
                } 
                else if (first + second + third > 0) {
                    high--;
                } 
                else {
                    low++;
                }

                if (found) {

                    found = false; 
                    while (low < n && nums[low] == second) {
                        low++;
                    }
                    while (high > -1 && nums[high] == third) {
                        high--;
                    }
                }
            }


            while (i < n && nums[i] == first) {
                i++;
            }
        }
        return answer;
    }
}
