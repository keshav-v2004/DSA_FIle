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

    public Queue<TreeNode> q = new LinkedList<>();

    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;
        TreeNode mover = root;
        preOrder(mover);

        mover = root;
        mover.left = null;
        q.poll();

        while(!q.isEmpty()){
            mover.left = null;

            TreeNode nextNode = q.poll();

            mover.right = nextNode;
            mover = mover.right;
        
        }
        mover.left = null;
        mover.right = null;

        return;

    }

    public void preOrder(TreeNode mover){
        if(mover==null) return ;

        q.offer(mover);
        preOrder(mover.left);
        preOrder(mover.right);


    }


}