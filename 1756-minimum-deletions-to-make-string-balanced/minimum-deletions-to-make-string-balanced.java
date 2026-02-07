class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        if (n <= 1) return 0;

        int[] prevB = new int[n];
        int[] suffA = new int[n];

        char ch = s.charAt(0);
        if (ch == 'b') {
            prevB[0] = 1;
        }

        ch = s.charAt(n - 1);
        if (ch == 'a') {
            suffA[n - 1] = 1;
        }

        // prefix B
        for (int i = 1; i < n; i++) {
            ch = s.charAt(i);
            if (ch == 'b') {
                prevB[i] = prevB[i - 1] + 1;
            } else {
                prevB[i] = prevB[i - 1];
            }
        }

        // suffix A
        for (int i = n - 2; i >= 0; i--) {
            ch = s.charAt(i);
            if (ch == 'a') {
                suffA[i] = suffA[i + 1] + 1;
            } else {
                suffA[i] = suffA[i + 1];
            }
        }

        int answer = Math.min(suffA[0], prevB[n - 1]);

        for (int i = 1; i < n; i++) {
            int del = prevB[i - 1] + suffA[i];
            answer = Math.min(answer, del);
        }

        return answer;
    }
}
