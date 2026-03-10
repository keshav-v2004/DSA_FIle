class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                visited[i] = 0;
                if (dfs(i, 0, graph, visited) == false) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean dfs(int i, int colorUsed, int[][] graph, int[] visited) {

        int[] neighbours = graph[i];

        for (int elem : neighbours) {

            if (visited[elem] == -1) {

                if (colorUsed == 0) {
                    visited[elem] = 1;
                    if (dfs(elem, 1, graph, visited)==false) {
                        return false;
                    }
                }

                else {
                    visited[elem] = 0;
                    if (dfs(elem, 0, graph, visited)==false) {
                        return false;
                    }
                }
            } else {
                if (visited[elem] == colorUsed) {
                    return false;
                }
            }

        }
        return true;
    }
}