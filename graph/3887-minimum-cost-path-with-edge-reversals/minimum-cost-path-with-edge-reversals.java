class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>(); 
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,2*w});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{0,0});
        
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        while(!q.isEmpty()){
            int[] ele = q.poll();
            int u=ele[0];
            int w=ele[1];
            if(w>dist[u])continue;
            for(int[] adjar : adj.get(u)){
                int adjval=adjar[0];
                int adjw=adjar[1];
                int newWt = w+adjw;
                if(newWt < dist[adjval]){
                    dist[adjval]=newWt;
                    q.add(new int[]{adjval,newWt});
                }
            }
        }
        return dist[n-1]==Integer.MAX_VALUE ? -1 : dist[n-1];

    }
}