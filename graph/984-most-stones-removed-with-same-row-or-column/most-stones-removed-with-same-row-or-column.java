class Solution {
    public int removeStones(int[][] stones) {
        int n =stones.length;
        int maxr=0;
        int maxc=0;
        for(int[] x : stones){
            maxr=Math.max(maxr,x[0]);
            maxc=Math.max(maxc,x[1]);
        }
        DisjointSet ds = new DisjointSet(maxr+maxc+2);
        HashSet<Integer> set = new HashSet<>();

        for(int[] x : stones){
            int noderow=x[0];
            int nodecol=x[1]+maxr+1;
            ds.unionBySize(noderow,nodecol);
            set.add(noderow);
            set.add(nodecol);
        }
        int cnt=0;
        for(int x : set){
            if(ds.findUPar(x)==x)cnt++;
        }
        //n is total nodes or stones present there
        // cnt is no. of connected nd disjoint components are there
        // so for a compnenet u need atleast one stone remain to be valid, so we simply take no. of componet and 
        // total stones - cnt will be  amount that can be removed
        return n-cnt;
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