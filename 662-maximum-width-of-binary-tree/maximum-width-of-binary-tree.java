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
    public int widthOfBinaryTree(TreeNode root) {
        if(root.left ==null && root.right ==null){
            return 1;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(
            new Node(root , 0)
        );
        List<List<Node>> bfs = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            List<Node> each = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                Node cur = q.poll();
                each.add(cur);

                int parentIndex = cur.index;
                TreeNode parent = cur.node;

                if(parent.left != null){
                    int leftChildIndex = 2*parentIndex + 1;
                    q.offer(
                        new Node(parent.left , leftChildIndex)
                    );
                }

                if(parent.right != null){
                    int rightChildIndex = 2*parentIndex + 2;
                    q.offer(
                        new Node(parent.right , rightChildIndex)
                    );
                }
            }
            bfs.add(each);
        }
        int maxDepth = 1;

        for(int i = 0 ; i < bfs.size() ; i++){
            Node first = bfs.get(i).get(0);
            Node last = bfs.get(i).get(bfs.get(i).size()-1);

            int l = first.index;
            int r = last.index;
            int depth = r-l+1;
            maxDepth = Math.max(maxDepth , depth);

        }
        return maxDepth;
    }
}

class Node{
    TreeNode node;
    int index;

    Node(TreeNode node , int index){
        this.node = node;
        this.index = index;
    }
}