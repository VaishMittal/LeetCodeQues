class Pair{
    int row;
    int col;
    int steps;
    Pair(int steps, int row, int col){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.steps-b.steps));
        pq.add(new Pair(1,0,0));
        grid[0][0]=1;
        while(!pq.isEmpty()){
            Pair p =pq.poll();
            int row=p.row;
            int col=p.col;
            int steps=p.steps;
            if(row==n-1 && col==n-1)return steps;

            int[] dr = {-1,-1,-1,1,1,1,0,0};
            int[] dc = {-1,0,1,-1,0,1,1,-1};
            for(int i=0;i<8;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(nr<n && nr>=0 && nc<n && nc>=0 && grid[nr][nc]==0){
                    pq.add(new Pair(steps+1,nr,nc));
                    grid[nr][nc]=1;
                }
            }
        }
        return -1;
       
    }
}
