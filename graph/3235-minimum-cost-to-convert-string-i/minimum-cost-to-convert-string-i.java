class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dis = new int[26][26];
        int INF = (int)1e9;

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j)dis[i][j]=0;
                else{
                    dis[i][j]=INF;
                }
            }
        }
        for(int i=0;i<original.length;i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            dis[u][v]=Math.min(dis[u][v], cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dis[i][k] + dis[k][j] < dis[i][j] ){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        long mincost=0;
        for(int i=0;i<source.length();i++){
            int u = source.charAt(i)-'a';
            int v = target.charAt(i)-'a';
            if(dis[u][v] == INF )return -1;
            mincost += dis[u][v];
        }
        return mincost;
    }
}