class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
//we will try to fill by two colors 0 and 1 and adjacent should have different color
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                q.add(i);
                vis[i]=0;
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int x : graph[node]){
                        if(vis[x]==-1){
                            q.add(x);
                            if(vis[node]==0){
                                vis[x]=1;
                            }else vis[x]=0;
                        }else{
                            if(vis[node]==vis[x]){
                                return false;
                            }
                        }
                    }
                }
            }
       
        }
        return true;
    }
}