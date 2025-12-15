class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        int island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    island++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return island;
    }
    public void dfs(char[][] grid, int row,int col, int[][] vis){
        vis[row][col]=1;
        int n = grid.length;
        int m = grid[0].length;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]=='1' ){
                dfs(grid,nr,nc,vis);
            }
        }
    }
}



// class Pair{ 
//     int row;
//     int col;
//     Pair(int row,int col){
//         this.row=row;
//         this.col=col;
//     }
// }
// class Solution {
//     public int numIslands(char[][] grid) {
//         int m =grid.length;
//         int n = grid[0].length;
//         int[][] vis = new int[m][n];
        
//         int c=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]=='1' && vis[i][j]==0){
//                     c++;
//                     bfs(i,j,vis,grid);
//                 }
//             }
//         }
//         return c;
//     }
//     public void bfs(int r,int c, int[][]vis,char[][] grid){
//         Queue<Pair> q = new LinkedList<>();
//         q.add( new Pair(r,c));
//         vis[r][c]=1;

//         int m =grid.length;
//         int n = grid[0].length; 

//         int[] dr = {-1, 1, 0, 0};
//         int[] dc = {0, 0, -1, 1};

//         while(!q.isEmpty()){
//             Pair pair = q.poll();
//             int row=pair.row;
//             int col=pair.col;

//             for(int i=0;i<4;i++){
//                 int nr=row+dr[i];
//                 int nc=col+dc[i];
//                 if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]=='1'){
//                     q.add(new Pair(nr,nc));
//                     vis[nr][nc]=1;
//                 }
//             }

//         }
//     }
// } 