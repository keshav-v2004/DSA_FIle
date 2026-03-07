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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->{
            return Long.compare(b,a);
        });
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            long sum = 0;

            for(int i = 0 ; i < size ; i++){

                TreeNode cur = q.poll();
                sum+=(long) cur.val;

                if(cur.left != null){
                    q.offer(cur.left);
                }
                
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            pq.offer(sum);
        }
        
        while(!pq.isEmpty() && k > 1){
            pq.poll();
            k--;
        }
        if(pq.isEmpty()){
            return -1;
        }
        else{
            return pq.poll();
        }
    }
}