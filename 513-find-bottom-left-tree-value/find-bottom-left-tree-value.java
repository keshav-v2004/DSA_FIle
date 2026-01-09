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
    public int findBottomLeftValue(TreeNode root) {
        
        int answer = -1;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        boolean isExtremeLeft = true;

        while(!q.isEmpty()){
            int size = q.size();
            isExtremeLeft = true;
            for(int i = 0 ; i < size ; i++){
                
                TreeNode each = q.poll();
                if(each.left!= null){
                    q.offer(each.left);
                }
                if(each.right!= null){
                    q.offer(each.right);
                }
                if(isExtremeLeft){
                    answer = each.val;
                    isExtremeLeft = false;
                }

            }
        }
        return answer;


    }


}