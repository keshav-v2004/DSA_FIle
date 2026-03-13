class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i< numCourses ; i++){
            adj.add(new ArrayList<>());

        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        int[] visited = new int[numCourses];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < numCourses ; i++){

            if(visited[i] == 0){

                // check if any cycle or deadlock is present --> if yes --> return empty array
                if( dfs(i,adj,stack , visited) == true ){
                    return new int[]{};

                }
            }
        }
        int[] answer = new int[stack.size()];
        int i= 0;

        while(!stack.isEmpty()){
            answer[i++] = stack.pop();
        }
        return answer;
    }

    public boolean dfs(int i , ArrayList<ArrayList<Integer>> adj ,
        Stack<Integer> stack , int[] visited
    ){

        visited[i] = 1;

        ArrayList<Integer> neighbours = adj.get(i);

        for(int elem : neighbours){

            if(visited[elem] == 1){
                // means cycle is present
                return true;
            }
            else if(visited[elem]==0){
                
                if(dfs(elem , adj , stack , visited)==true){
                    return true;
                }
            }
        }
        visited[i] = 2;
        stack.push(i);

        return false;
    }


}