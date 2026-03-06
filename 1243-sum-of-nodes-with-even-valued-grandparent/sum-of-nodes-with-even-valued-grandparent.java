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
    Map<TreeNode , TreeNode> map = new HashMap<>();

    public int sumEvenGrandparent(TreeNode root) {
        map.put(root , null);

        TreeNode mover = root;
        dfs(mover);

        int sum = 0;

        for(Map.Entry<TreeNode , TreeNode> entry : map.entrySet()){

            TreeNode cur = entry.getKey();
            TreeNode parent = entry.getValue();

            if(parent != null){

                TreeNode grandparent = map.get(parent);
                if(grandparent != null){

                    if(grandparent.val % 2 == 0){
                        sum+=cur.val;
                    }
                }
            }
        }
        return sum;
    }

    public void dfs(TreeNode mover){
        if(mover==null){
            return ;
        }

        if(mover.left != null){
            map.put(mover.left , mover);
            dfs(mover.left);
        }
        if(mover.right != null){
            map.put(mover.right , mover);
            dfs(mover.right);
        }

    }
}