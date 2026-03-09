class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {

                // if cycle is present ( deadlock ) --> cannot complete all the courses
                if (dfs(adj, visited, i) == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int current) {

        visited[current] = 1;

        ArrayList<Integer> neighbours = adj.get(current);

        for (int elem : neighbours) {
            if (visited[elem] == 0) {

                boolean cyclePresent = dfs(adj, visited, elem);

                if (cyclePresent == true) {
                    return true;
                }

            } else if (visited[elem] == 1) {
                return true;
            }
        }
        visited[current] = 2; // mark finished
        return false;
    }
}