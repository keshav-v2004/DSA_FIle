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
class BSTIterator {
    public List<Integer> inorder;
    public int index = -1;
    
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();

        iot(root);
    }

    public void iot(TreeNode mover){
        if(mover==null) return;

        iot(mover.left);
        inorder.add(mover.val);
        iot(mover.right);
    }
    
    public int next() {
        
        int elem = inorder.get(index+1);
        index++;
        return elem;
    }
    
    public boolean hasNext() {
        if(index <  inorder.size()-1) return true;

        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */