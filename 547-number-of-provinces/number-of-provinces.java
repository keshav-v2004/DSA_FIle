class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DisjointSet ds = new DisjointSet(n);

        int count = 0;

        // Union
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    ds.unionByRank(i, j);
                }
            }
        }

        // Count components
        for(int i = 0; i < n; i++){
            if(ds.findParent(i) == i){
                count++;
            }
        }

        return count;
    }
}

class DisjointSet{
    
    int n;
    
    int[] parent;
    int[] rank;
    int[] size;
    
    DisjointSet(int n){
        
        this.n = n;
        parent = new int[n+1];
        rank = new int[n+1];
        size = new int[n+1];
        
        for(int i = 1 ; i <= n ; i++){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
        
    }
    
    void unionByRank(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
    
        if(ulp_u == ulp_v) return;
    
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_v] < rank[ulp_u]){
            parent[ulp_v] = ulp_u;
        }
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    
    void unionBySize(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
    
        if(ulp_u == ulp_v) return;
    
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
    
    int findParent(int u){
        
        if(parent[u] == u){
            return u;
            
        }
        
        parent[u] = findParent(parent[u]);
        return parent[u];
        
    }
    
}