class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();

        int i = 0;

        while (true) {
            int xPow = (int) Math.pow(x, i);
            if (xPow > bound) break;

            int j = 0; 

            while (true) {
                int yPow = (int) Math.pow(y, j);
                if (xPow + yPow > bound) break;

                set.add(xPow + yPow);

                
                if (y == 1) break;
                j++;
            }
            if (x == 1) break;
            i++;
        }

        return new ArrayList<>(set);
    }
}
