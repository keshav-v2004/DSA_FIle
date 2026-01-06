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
    public int maxLevelSum(TreeNode root) {
        int sum = Integer.MIN_VALUE;

        int level = 1;
        int answer = -1;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int levelSum = 0;
            for(int i = 0 ; i < size ; i++){
                TreeNode each = q.poll();
                levelSum+=each.val;
                if(each.left!= null){
                    q.offer(each.left);
                }
                if(each.right!= null){
                    q.offer(each.right);
                }
            }
            if(levelSum > sum){
                answer = level;
                sum = levelSum;
            }
            level++;
        }
        return answer;

    }
}