class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        for(int i=0;i<n;i++){
            revadj.add(new ArrayList<>());
        }
        int[] indeg=new int[n];
        //indirectly we are reversing arrays
        for(int i=0;i<n;i++){
            for(int x : graph[i]){
                revadj.get(x).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int x : revadj.get(node)){
                indeg[x]--;
                if(indeg[x]==0){
                    q.add(x);
                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
}












// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         int [] vis=new int[n];
//         int[] pathvis = new int[n];
//         int[] mark = new int[n];

//         for(int i=0;i<n;i++){
//             if(vis[i]==0){
//                 if(!checkCycle(i,vis,pathvis,mark,graph)){
//                     mark[i]=1;
//                 }
//             }
//         }
//         ArrayList<Integer> ans = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             if(mark[i]==1)ans.add(i);
//         }
//         return ans;
//     }
//     public boolean checkCycle(int node, int[] vis, int[] pathvis, int[] mark,int[][] graph){
//         vis[node]=1;
//         pathvis[node]=1;

//         for(int x : graph[node]){
//             if(vis[x]==0){
//                 if(checkCycle(x,vis,pathvis,mark,graph))return true;
//             }
//             else if(pathvis[x]==1){
//                 return true;
//             }
//         }
//         pathvis[node]=0;
//         mark[node]=1;
//         return false;
//     }
// }