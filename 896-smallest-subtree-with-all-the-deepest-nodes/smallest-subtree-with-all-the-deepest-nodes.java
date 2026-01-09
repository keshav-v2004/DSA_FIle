/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }    
 * }
 */
class Solution {


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }

        int md = maxDepth(root);

        TreeNode answer = dfs(root, md, 0);

        return answer;
    }

    public int maxDepth(TreeNode mover) {
        if (mover == null)
            return 0;

        int left = maxDepth(mover.left);
        int right = maxDepth(mover.right);

        return 1 + Math.max(left, right);
    }

    public TreeNode dfs(TreeNode mover, int maxDepth, int depth) {

        if (depth == maxDepth-1 ) {
            return mover;
        }

        TreeNode left = null;
        TreeNode right = null;
        if(mover.left!= null) {
            left = dfs(mover.left , maxDepth , depth+1);
        }

        if(mover.right!= null){
            right = dfs(mover.right,maxDepth , depth+1);
        }

        if(left != null && right!= null) return mover;
        if(left !=null){
            return left;
        }
        return right;

    }

}