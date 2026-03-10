class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        List<Integer> answer = new ArrayList<>();
        int[] visited = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(dfs(i , graph , visited)){
                answer.add(i);
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public boolean dfs(int i , int[][] graph , int[] visited){

        if(visited[i] == 1) return false; // cycle
        if(visited[i] == 2) return true;  // already safe
        if(visited[i] == 3) return false; // already unsafe

        visited[i] = 1; // visiting

        int[] neighbours = graph[i];

        for(int elem : neighbours){
            if(!dfs(elem , graph , visited)){
                visited[i] = 3; // mark unsafe
                return false;
            }
        }

        visited[i] = 2; // mark safe
        return true;
    }
}