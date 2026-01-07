
class Solution {
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis=new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j]==1){
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r=node[0];
            int c=node[1];
            dfs(vis,board,r,c);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==1){
                    board[i][j]=2;
                }
            }
        }
        int unvis=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    unvis++;
                }
            }
        }
        return unvis;

    }
    public void dfs(int[][] vis,int[][] board,int row, int col){
        vis[row][col]=1;
        int[] dr = {-1,1,0,0};
        int[] dc= {0,0,-1,1};
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]==1 && vis[nr][nc]==0){
                dfs(vis,board,nr,nc);
            }
        }
    }
}