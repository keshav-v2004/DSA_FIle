class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        Queue<New> q = new LinkedList<>();

        q.offer(new New(root, 0, 0));

        while (!q.isEmpty()) {
            New cur = q.poll();

            map.putIfAbsent(cur.col, new ArrayList<>());
            map.get(cur.col).add(new int[]{cur.row, cur.node.val});

            if (cur.node.left != null)
                q.offer(new New(cur.node.left, cur.col - 1, cur.row + 1));

            if (cur.node.right != null)
                q.offer(new New(cur.node.right, cur.col + 1, cur.row + 1));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        List<List<Integer>> answer = new ArrayList<>();

        while (!pq.isEmpty()) {
            int c = pq.poll();
            List<int[]> list = map.get(c);

            Collections.sort(list, (a, b) ->
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
            );

            List<Integer> colList = new ArrayList<>();
            for (int[] p : list) colList.add(p[1]);

            answer.add(colList);
        }
        return answer;
    }
}

class New {
    TreeNode node;
    int col, row;

    New(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}
