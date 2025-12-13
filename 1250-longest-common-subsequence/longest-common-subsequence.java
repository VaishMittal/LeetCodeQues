class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int ans=0;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    ans = 1 + dp[i-1][j-1];
                }else{
                    ans = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[n][m];
    }

}






// // tabulatio by shifting -1 to 0 by increasing idx by1 

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int idx1=text1.length();
//         int idx2 = text2.length();
//         int[][] dp = new int[idx1+1][idx2+1];
//         for( int[] row : dp){
//                 Arrays.fill(row,-1);
//         }
//         //base case
//         for(int i=0;i<=idx1;i++)dp[i][0]=0;
//         for(int j=0;j<=idx2;j++)dp[0][j]=0;

//         for(int i=1;i<=idx1;i++){
//             for(int j=1;j<=idx2;j++){
//                 if(text1.charAt(i-1)==text2.charAt(j-1)){
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 }
//                 else dp[i][j] =  Math.max(dp[i][j-1], dp[i-1][j]);
//             }
//         }
//         return dp[idx1][idx2];
//     }

// }
//recursion with memoization

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int idx1=text1.length();
//         int idx2 = text2.length();
//         int[][] dp = new int[idx1][idx2];
//         for( int[] row : dp){
//                 Arrays.fill(row,-1);
//         }
//         return find(text1,text2,idx1-1,idx2-1,dp);
//     }
//     public int find(String text1,String text2,int idx1,int idx2, int[][] dp){
//         if(idx1<0 || idx2<0) return 0;
//         if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//         if(text1.charAt(idx1)==text2.charAt(idx2)){
//             return 1 + find(text1,text2,idx1-1,idx2-1,dp);
//         }
//         return dp[idx1][idx2] =  Math.max(find(text1,text2,idx1,idx2-1,dp),find(text1,text2,idx1-1,idx2,dp));
//     }
// }