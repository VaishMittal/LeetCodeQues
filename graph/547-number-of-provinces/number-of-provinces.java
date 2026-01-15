class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        // List<List<Integer>> adj = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0){
                    ds.unionByRank(i,j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i)cnt++;
        }
        return cnt;
    }
}

class DisjointSet{
    int[] rank,parent;
    
    DisjointSet(int n){
        rank=new int[n];
        parent=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    
    int findUPar(int node){
        if(node==parent[node])return node;
        return parent[node]=findUPar(parent[node]);
    }
    
    void unionByRank(int u, int v){
        int uUPar=findUPar(u);
        int vUPar=findUPar(v);
        if(uUPar==vUPar)return;
        
        if(rank[uUPar]>rank[vUPar]){
            parent[vUPar]=uUPar;
        }
        else if(rank[uUPar]<rank[vUPar]){
            parent[uUPar]=vUPar;
        }else{
            parent[uUPar]=vUPar;
            rank[vUPar]++;
        }
    }
}