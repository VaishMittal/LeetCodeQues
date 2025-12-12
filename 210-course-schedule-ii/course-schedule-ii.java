class Solution {
    public int[] findOrder(int n, int[][] preq) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[n];
        for(int i=0;i<preq.length;i++){
            adj.get(preq[i][1]).add(preq[i][0]);
            indeg[preq[i][0]]+=1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0)q.add(i);
        }
        // ArrayList<Integer> ans = new ArrayList<>();
        int[] ans = new int[n];
        int c=0;
        int k=0;
        while(!q.isEmpty()){
            int node = q.poll();
            c++;
            for(int x : adj.get(node)){
                indeg[x]--;
                if(indeg[x]==0)q.add(x);
            }
            ans[k++]=node;
            // ans.add(node);
        }
        // if(ans.size()!=n)return new int[]{};
        // else return ans;
        if(c==n)return ans;
        else return new int[]{};
    }
}