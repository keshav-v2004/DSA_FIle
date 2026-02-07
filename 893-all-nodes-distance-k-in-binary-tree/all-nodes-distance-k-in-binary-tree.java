/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root, null);

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    map.put(cur.left, cur);
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    map.put(cur.right, cur);
                    q.offer(cur.right);
                }
            }
        }

        Set<TreeNode> set = new HashSet<>();
        q.offer(target);
        set.add(target);

        while (k > 0) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left != null && !set.contains(cur.left)) {
                    q.offer(cur.left);
                    set.add(cur.left);
                }

                if (cur.right != null && !set.contains(cur.right)) {
                    q.offer(cur.right);
                    set.add(cur.right);
                }
                if (map.get(cur) != null && !set.contains(map.get(cur))) {
                    q.offer(map.get(cur));
                    set.add(map.get(cur));
                }
            }
            k--;

        }

        List<Integer> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            answer.add(q.poll().val);
        }
        return answer;

    }
}