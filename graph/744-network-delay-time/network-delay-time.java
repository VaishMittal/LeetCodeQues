class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();  //in adj we have int array of [time,node]

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new int[]{t,v});
        }

        int [] time = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        time[0]=-1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);//[time,node]

        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int t =arr[0];
            int node=arr[1];

            if(time[node]<t)continue;

            for(int[] x : adj.get(node)){
                int adjtime=x[0];
                int adjnode=x[1];
                if(time[adjnode] > t + adjtime){
                    time[adjnode] = t + adjtime;
                    pq.add(new int[]{t+adjtime,adjnode});
                }
            }
        }
        int maxi=-1;
        for(int i=0;i<=n;i++){
            if(time[i]==Integer.MAX_VALUE)return -1;
            else{
                maxi=Math.max(maxi,time[i]);
            }
        }
        return maxi;


    }
}