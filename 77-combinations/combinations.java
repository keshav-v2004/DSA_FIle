class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> each = new ArrayList<>();

        helper(n, k, each);

        return answer;
    }

    public void helper(int n, int k, List<Integer> each) {

        if (k == 0) {
            answer.add(new ArrayList<>(each));
            return;
        }

        if (n == 0) {
            return;
        }

        // choose this 
        each.add(n);
        helper(n - 1, k - 1, each);

        // skip this
        each.remove(each.size() - 1);
        helper(n - 1, k, each);

    }
}