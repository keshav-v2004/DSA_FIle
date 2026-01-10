/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        if (root == null)
            return levelOrder;

            
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> each = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();


                for(int j = 0 ; j < cur.children.size() ; j++){
                    Node child = cur.children.get(j);
                    q.offer(child);
                }
                each.add(cur.val);

            }
            levelOrder.add(each);
        }

        return levelOrder;
    }
}