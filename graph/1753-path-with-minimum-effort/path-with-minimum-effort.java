class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});

        int[][] mat = new int[m][n];
        for(int[] row : mat){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        mat[0][0]=0;
        
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int dist= p[0];
            int r = p[1];
            int c = p[2];
            if(r==m-1 && c==n-1)return dist;

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n ){
                    int neweffort = Math.max(dist,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(mat[nr][nc]>neweffort){
                        mat[nr][nc]=neweffort;
                        pq.add(new int[]{neweffort,nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}