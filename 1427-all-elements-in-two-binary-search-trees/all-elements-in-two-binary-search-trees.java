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
    PriorityQueue<Integer> pq= new PriorityQueue<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        dfs(root1);
        dfs(root2);

        List<Integer> answer = new ArrayList<>();

        while(!pq.isEmpty()){
            answer.add(pq.poll());
        }
        return answer;

    }
    public void dfs(TreeNode mover){
        if(mover==null) return;

        pq.offer(mover.val);
        dfs(mover.left);
        dfs(mover.right);
    }
}