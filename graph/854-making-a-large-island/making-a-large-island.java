class Solution {
    public int largestIsland(int[][] grid) {
        int n =grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                int[] dr ={-1,1,0,0};
                int[] dc={0,0,-1,1};
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc =j+dc[k];
                    if(nr>=0 && nc>=0 && nr<n && nc< n){
                        if(grid[nr][nc]==1){
                            int nodeNo=i*n+j;
                            int adjNodeNo=nr*n+nc;
                            if(ds.findUPar(nodeNo)!=ds.findUPar(adjNodeNo)){
                                ds.unionBySize(nodeNo,adjNodeNo);
                            }
                        }
                    }
                }
            }
        }
        int mx=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)continue;
                Set<Integer> set = new HashSet<>();
                int[] dr ={-1,1,0,0};
                int[] dc={0,0,-1,1};
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc =j+dc[k];
                    if(nr>=0 && nc>=0 && nr<n && nc< n){
                        if(grid[nr][nc]==1){
                            int nodeNo=i*n+j;
                            int adjNodeNo=nr*n+nc;
                            set.add(ds.findUPar(adjNodeNo));
                        }
                    }
                }
                int cnt=1;
                for(int node : set){
                    cnt+=ds.size[node];
                }
                mx=Math.max(mx,cnt);

            }
        }
        for(int i=0;i<n*n;i++){
            mx=Math.max(mx,ds.size[ds.findUPar(i)]);
        }

        return mx;

        
    }
}

class DisjointSet{
    int[] rank,parent,size;
    
    DisjointSet(int n){
        rank=new int[n];
        parent=new int[n];
        size=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
            size[i]=1;
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
    void unionBySize(int u, int v){
        int uUPar = findUPar(u);
        int vUPar = findUPar(v);
        if(uUPar==vUPar)return;
        if(size[uUPar]>size[vUPar]){
            parent[vUPar]=uUPar;
            size[uUPar]+=size[vUPar];
        }else{
            parent[uUPar]=vUPar;
            size[vUPar]+=size[uUPar];
        }
    }
}