class Solution {

    StringBuilder answer = new StringBuilder();

    public String tree2str(TreeNode root) {

        if (root.left == null && root.right == null) {
            answer.append(root.val);
            return answer.toString();
        }

        helper(root);
        return answer.toString();
    }

    public void helper(TreeNode mover) {

        if (mover.left == null && mover.right == null) {
            answer.append(mover.val);
            return;
        }

        answer.append(mover.val);

        
        if (mover.left == null && mover.right != null) {
            answer.append("()");
        }

        if (mover.left != null) {
            answer.append('(');
            helper(mover.left);
            answer.append(')');
        }
        if (mover.right != null) {
            answer.append('(');
            helper(mover.right);
            answer.append(')');
        }
    }
}
