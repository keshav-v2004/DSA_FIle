class Solution {
    int count = 0;
    long target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if (root == null) return 0;
        helper(root);
        return count;
    }

    private ArrayList<Long> helper(TreeNode node) {
        ArrayList<Long> allPossible = new ArrayList<>();

        if (node.left != null) {
            ArrayList<Long> left = helper(node.left);
            for (long s : left) {
                long sum = s + node.val;
                if (sum == target) count++;
                allPossible.add(sum);
            }
        }

        if (node.right != null) {
            ArrayList<Long> right = helper(node.right);
            for (long s : right) {
                long sum = s + node.val;
                if (sum == target) count++;
                allPossible.add(sum);
            }
        }

        if (node.val == target) count++;
        allPossible.add((long) node.val);

        return allPossible;
    }
}
