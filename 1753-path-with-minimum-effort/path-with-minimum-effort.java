class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] dist = new int[n][m];

        for(int[] x : dist)
        Arrays.fill(x,Integer.MAX_VALUE);

        pq.add(new int[]{0,0,0});
        dist[0][0]=0;

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int diff = p[0];
            int row = p[1];
            int col = p[2];

            int[]dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            if(row==n-1 && col==m-1)return diff;

            for(int i=0;i<4;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    int neweffort = Math.max(
                        Math.abs(grid[row][col] - grid[nr][nc]),
                        diff
                    );
                    if(dist[nr][nc]>neweffort){
                        dist[nr][nc]=neweffort;
                        pq.add(new int[]{neweffort,nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}