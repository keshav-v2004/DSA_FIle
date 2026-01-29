class Solution {
    static final long mod = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long oddCount;
        long evenCount;

        if (n % 2 == 0) {
            evenCount = n / 2;
            oddCount = n / 2;
        } else {
            evenCount = (n / 2) + 1;
            oddCount = n / 2;
        }

        long answer =
                modPow(5, evenCount) * modPow(4, oddCount) % mod;

        return (int) answer;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
