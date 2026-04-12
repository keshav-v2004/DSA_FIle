class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);

        if (!(sides[0] + sides[1] > sides[2] &&
              sides[1] + sides[2] > sides[0] &&
              sides[0] + sides[2] > sides[1])) {
            return new double[0];
        }

        double a2 = sides[0] * sides[0];
        double b2 = sides[1] * sides[1];
        double c2 = sides[2] * sides[2];

        double angle1 = (a2 + b2 - c2) / (2.0 * sides[0] * sides[1]);
        double angle2 = (b2 + c2 - a2) / (2.0 * sides[1] * sides[2]);
        double angle3 = (a2 + c2 - b2) / (2.0 * sides[0] * sides[2]);



        angle1 = Math.toDegrees(Math.acos(angle1));
        angle2 = Math.toDegrees(Math.acos(angle2));
        angle3 = Math.toDegrees(Math.acos(angle3));

        double[] answer = new double[]{angle1, angle2, angle3};
        Arrays.sort(answer);
        return answer;
    }
}