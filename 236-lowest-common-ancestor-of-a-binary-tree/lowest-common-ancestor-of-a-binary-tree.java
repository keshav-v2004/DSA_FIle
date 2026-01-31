/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode mover = root;

        return helper(mover , p , q);
    }

    public TreeNode helper(TreeNode mover , TreeNode p , TreeNode q){

        if(mover==null) return null;

        if(mover==p || mover==q) {
            if(mover==p) return p;
            return q;
        }

        TreeNode left = helper(mover.left ,p,q);
        TreeNode right = helper(mover.right , p , q);

        if(left != null && right != null){
            return mover;
        }
        else{
            if(left == null) return right;
            return left;
        }

    }
}