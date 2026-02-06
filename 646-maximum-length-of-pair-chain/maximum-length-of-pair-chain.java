class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int max = 1;
        int prev = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            int elem = pairs[i][0];

            if (elem > prev) {
                max++;
                prev = pairs[i][1];
            }
        }

        return max;
    }
}
