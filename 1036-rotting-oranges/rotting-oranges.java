class Solution {
    public int orangesRotting(int[][] grid) {
        int time=0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;//to check if fresh orange exist or not
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1)fresh++;
            }
        }
        if(fresh==0)return 0;

        while(!q.isEmpty()){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] pair=q.poll();
                int x=pair[0];
                int y=pair[1];
                int[] dr = {-1,1,0,0};
                int[] dc = {0,0,-1,1};
                for(int j=0;j<4;j++){
                    int nr = x+dr[j];
                    int nc = y+dc[j];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time-1;
    }
}
