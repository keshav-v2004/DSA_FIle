class Solution {
    public int minAllOneMultiple(int k) {
        Set<Integer> set = new HashSet<>();
        int prev = 0;
        int digits = 0;

        while (true) {
            int number = prev * 10 + 1;
            int rem = number % k;
            digits++;

            if (rem == 0) return digits;
            if (set.contains(rem)) return -1;

            set.add(rem);
            prev = rem;
        }
    }
}
