class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long answer = -1;
        long lb = 0;
        long ub = (long)1e16;

        while (lb <= ub) {

            long mid = lb + (ub - lb) / 2;

            if (helper(mountainHeight, workerTimes, mid)) {
                answer = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return answer;
    }

    public boolean helper(int mountainHeight, int[] workerTimes, long mid) {

        long heightCalculated = 0;

        for (int elem : workerTimes) {

            heightCalculated += helper2(elem, mid);

            if (heightCalculated >= mountainHeight) {
                return true;
            }
        }
        return false;
    }

    public long helper2(int workerTime, long mid) {

        long val = 1 + (8 * mid / workerTime);
        double discriminant = Math.sqrt(val);

        return (long)((-1 + discriminant) / 2);
    }
}