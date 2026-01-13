class Solution {
    public int findTheCity(int n, int[][] edges, int thresh) {
        int[][] dist = new int[n][n];

        for(int[] row : dist)
        Arrays.fill(row,Integer.MAX_VALUE);
        for(int i = 0; i < n; i++){
            dist[i][i] = 0;
        }


        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            dist[u][v]=w;
            dist[v][u]=w;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE
                    && dist[i][j]> dist[i][k]+dist[k][j] ){
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= thresh) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                ans = i;
            }
        }
        return ans;
    }
}