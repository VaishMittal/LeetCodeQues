class Solution {
    public void gameOfLife(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] clone = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                clone[i][j]=mat[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int live=findlive(i,j,clone);
                if(clone[i][j]==1){
                    if(live==2 || live==3){
                        mat[i][j]=1;
                    }else{
                        mat[i][j]=0;
                    }
                }else{
                    if(live==3){
                        mat[i][j]=1;
                    }
                }
            }
        }
    }
    public int findlive(int i,int j,int[][] clone){
        int live=0;
        int n=clone.length;
        int m=clone[0].length;
        if(i+1<n && clone[i+1][j]==1)live++;
        if(i+1<n && j-1>=0 && clone[i+1][j-1]==1)live++;
        if(i+1<n && j+1<m && clone[i+1][j+1]==1)live++;

        if(i-1>=0 && clone[i-1][j]==1)live++;
        if(i-1>=0 && j+1<m && clone[i-1][j+1]==1)live++;
        if(i-1>=0 && j-1>=0 && clone[i-1][j-1]==1)live++;

        if(j+1<m && clone[i][j+1]==1)live++;
        if(j-1>=0 && clone[i][j-1]==1)live++;

        return live;
    }
}