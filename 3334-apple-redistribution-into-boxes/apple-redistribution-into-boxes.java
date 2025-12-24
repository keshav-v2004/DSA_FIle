class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) totalApples += a;

        Integer[] c = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) c[i] = capacity[i];

        Arrays.sort(c, Collections.reverseOrder());

        int usedCapacity = 0;
        int boxes = 0;

        for (int cap : c) {
            usedCapacity += cap;
            boxes++;
            if (usedCapacity >= totalApples) {
                return boxes;
            }
        }

        return boxes;
    }
}
