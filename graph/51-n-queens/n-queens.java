class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board=new char[n][n];//[".Q..","...Q","Q...","..Q."]
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        find(n, ans, board, 0);
        return ans;
        
    }
    public void find(int n, List<List<String>> ans, char[][] board, int row ){
        if(row==n){
            List<String> list = new ArrayList<>();   
            for(int i=0;i<n;i++){
                list.add(new String(board[i]));
            }
            ans.add( list);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(row,i,board,n)){
                board[row][i]='Q';
                find(n,ans,board,row+1);
                board[row][i]='.';
            }
        }
    }
    public boolean isSafe(int row, int col, char[][] board, int n){
        //row check
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q')return false;
        }
        //col check
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q')return false;
        }
        //leftupward diagonal
        for(int i=row,j=col;i>=0 && j>=0 ;i--,j--){
            if(board[i][j]=='Q')return false;
        }
        //right upward diagonal
        for(int i=row,j=col;i>=0 && j<n ;i--,j++){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }


}