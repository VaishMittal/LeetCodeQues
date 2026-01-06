class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int provinces=0;
        Queue<Integer> q = new LinkedList<>();
        int[] vis= new int[n];
        for(int i=0;i<n;i++){
            q.add(i);
            if(vis[i]==0){
                provinces++;
                while(!q.isEmpty()){
                    vis[i]=1;
                    int node=q.poll();
                    for(int x : adj.get(node)){
                        if(vis[x]==0){
                            vis[x]=1;
                            q.add(x);
                        }
                    }
                }
            }
        }
        return provinces;
    }
}