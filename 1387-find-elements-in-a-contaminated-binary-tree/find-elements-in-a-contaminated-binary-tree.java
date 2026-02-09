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
class FindElements {
    
    TreeNode root;

    public FindElements(TreeNode root) {

        this.root = root;
        root.val = 0;

        TreeNode mover = root;


        dfs(mover);



    }
    
    public boolean find(int target) {
        return helper(root , target);
    }

    boolean helper(TreeNode mover , int target){
        if(mover==null){
            return false;

        }

        if(mover.val==target) return true;

        return helper(mover.left , target) || helper(mover.right , target);
    }

    void dfs(TreeNode mover){
        if(mover==null) return;

        if(mover.left != null){
            mover.left.val = 2*(mover.val) +1;
            dfs(mover.left);
        }
        
        if(mover.right != null){
            mover.right.val = 2*(mover.val) +2;
            dfs(mover.right);
        }
        

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */