class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int seg1 = 0;
        int seg2 = 0;

        int n1 = v1.length;
        int n2 = v2.length;

        while (seg1 < n1 && seg2 < n2) {
            String op1 = v1[seg1];
            String op2 = v2[seg2];

            int x = 0;
            int y = 0;

            for (char ch : op1.toCharArray()) {
                x = (x * 10) + (ch - '0');
            }
            for (char ch : op2.toCharArray()) {
                y = (y * 10) + (ch - '0');
            }

            if (x < y) {
                return -1;
            } else if (x > y) {
                return 1;
            }

            seg1++;
            seg2++;
        }

        while(seg1 < n1){
            String op1 = v1[seg1];
            String op2 = "0";

            int x = 0;
            int y = 0;

            for (char ch : op1.toCharArray()) {
                x = (x * 10) + (ch - '0');
            }
            for (char ch : op2.toCharArray()) {
                y = (y * 10) + (ch - '0');
            }

            if (x < y) {
                return -1;
            } else if (x > y) {
                return 1;
            }
            seg1++;
        }

        while(seg2 < n2){
            String op1 = "0";
            String op2 = v2[seg2];

            int x = 0;
            int y = 0;

            for (char ch : op1.toCharArray()) {
                x = (x * 10) + (ch - '0');
            }
            for (char ch : op2.toCharArray()) {
                y = (y * 10) + (ch - '0');
            }

            if (x < y) {
                return -1;
            } else if (x > y) {
                return 1;
            }
            seg2++;
        }
        return 0;
    }

}