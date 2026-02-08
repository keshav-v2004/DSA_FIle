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

    public int amountOfTime(TreeNode root, int start) {
        

        map.put(root , null);
        TreeNode mover = root;
        dfs(mover);

        mover = root;
        TreeNode target = findStart(mover , start);

        int time = 0;
        

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        


        q.offer(target);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode cur = q.poll();

                visited.add(cur);

                if(cur.left != null && !visited.contains(cur.left)){
                    q.offer(cur.left);

                }
                
                if(cur.right != null && !visited.contains(cur.right)){
                    q.offer(cur.right);
                }
                if(map.get(cur) != null && !visited.contains(map.get(cur))){
                    q.offer(map.get(cur));
                }
            }
            time++;
        }
        return time-1;

    }


    TreeNode findStart(TreeNode mover , int start){
        if(mover==null){
            return null;
        }

        if(mover.val==start){
            return mover;
        }
        TreeNode left = findStart(mover.left , start);
        TreeNode right = findStart(mover.right , start);

        if(left==null && right==null){
            return null;
        }
        else{
            if(left==null) return right;
            return left;
        }
    }

    public void dfs(TreeNode mover){
        if(mover==null){
            return;
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