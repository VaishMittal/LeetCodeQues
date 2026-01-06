class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if (image[sr][sc] == color) return image;
        int prevColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int [] node = q.poll();
            int r=node[0];
            int c = node[1];
            int [] dr ={0,0,-1,1};
            int [] dc= {-1,1,0,0};
            image[r][c] = color;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==prevColor){
                    image[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return image;

    }
}