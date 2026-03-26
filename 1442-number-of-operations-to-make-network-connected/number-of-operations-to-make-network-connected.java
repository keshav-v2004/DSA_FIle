class Solution {

    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);

        int countExtra = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                countExtra++;
            }
            else{
                ds.unionByRank(u,v);
            }
        }

        int ultimateParent = 0;
        for(int i = 0 ; i < n ; i++){
            if(ds.findParent(i) == i){
                ultimateParent++;
            }
        }

        int edgesRequired = ultimateParent-1;
        if(countExtra >= edgesRequired){
            return edgesRequired;
        }

        return -1;


    }
}

class DisjointSet{
    
    int n;
    
    int[] parent;
    int[] rank;
    int[] size;
    
    DisjointSet(int n){
        
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        
        for(int i = 0 ; i < n ; i++){
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