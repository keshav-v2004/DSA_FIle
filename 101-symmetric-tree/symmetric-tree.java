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
    public boolean isSymmetric(TreeNode root) {
        if(root.left ==null && root.right==null){
            return true;
        }

        TreeNode left = root;
        TreeNode right = root;

        return helper(left , right);
    }

    boolean helper(TreeNode left , TreeNode right){
        if(left==null || right ==null){
            if(left==null && right ==null) return true;

            return false;
        }

        if(left.val != right.val) return false;

        boolean ldepth = helper(left.left , right.right);
        boolean rdepth = helper(left.right , right.left);

        return ldepth && rdepth;


    }


}