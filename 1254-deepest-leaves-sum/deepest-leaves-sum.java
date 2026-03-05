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
    public int deepestLeavesSum(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            ArrayList<Integer> each = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                TreeNode cur = q.poll();

                if(cur.left != null){
                    q.offer(cur.left);

                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                each.add(cur.val);
            }
            bfs.add(each);
        }

        int sum = 0;
        for(int elem : bfs.get(bfs.size()-1)){
            sum+=elem;
        }
        return sum;
    }
}