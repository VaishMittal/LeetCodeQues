class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n =mat[0].length;
        int[][] vis=new int[m][n];
        int[][] dis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    dis[i][j]=0;
                    q.add(new int[] {i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r = arr[0];
            int c=arr[1];
            int d=arr[2];

            int[] dr={-1,1,0,0};
            int[] dc={0,0,-1,1};

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    dis[nr][nc]=d+1;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        return dis;
    }
}