class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int n = numCourses;
        int[]ans= new int[n];

        Queue<Integer> q = new LinkedList<>();
        int[] indeg= new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
            indeg[pre[i][0]]++;
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int j=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[j++]=node;

            for(int x : adj.get(node)){
                indeg[x]--;
                if(indeg[x]==0)q.add(x);
            }

        }
        if(j==n)return ans;
        else return new int[] {};
    }
}