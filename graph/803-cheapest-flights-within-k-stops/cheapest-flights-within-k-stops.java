class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //adj nodes with cost to reach that node
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int price = flights[i][2];

            adj.get(s).add(new int[]{d,price});
        }
        Queue<int[]> q = new LinkedList<>();
        // in queue we have[steps,node,dist]
        q.add(new int[]{0,src,0});

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!q.isEmpty()){
            int[] e = q.poll();
            int step=e[0];
            int curnode=e[1];
            int dis=e[2];

            if(step>k) continue;

            for(int[] x:adj.get(curnode) ){
                int node=x[0];
                int d=x[1];
                int newdis = dis+d;
                if(dist[node]>newdis && step<=k){
                    dist[node]=newdis;
                    q.add(new int[]{step+1,node,newdis});
                }
            }
        }
        if(dist[dst]!=Integer.MAX_VALUE){
            return dist[dst];
        }else return -1;

    }
}