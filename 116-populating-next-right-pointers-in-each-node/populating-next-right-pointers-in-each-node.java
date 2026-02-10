/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root==null) return null;

        List<List<Node>> bfs = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        Node mover = root;

        q.offer(mover);

        while(!q.isEmpty()){

            int size = q.size();
            List<Node> each = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                Node cur = q.poll();

                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                each.add(cur);
            }
            bfs.add(each);
        }

        for(List<Node> level : bfs){

            for(int i = 0 ; i < level.size() ; i++){
                
                Node cur = level.get(i);

                if(i==level.size()-1){
                    cur.next = null;
                }
                else{
                    cur.next = level.get(i+1);
                }
            }
        }
        return root;
    }
}