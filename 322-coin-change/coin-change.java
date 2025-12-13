class Solution {
    static final int INF = 1_000_000_000;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        //base case
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=INF;
            }
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notpick = dp[i-1][t];
                int pick=INF;
                if(t>=coins[i] && dp[i][t-coins[i]]!=INF){
                    pick = 1+ dp[i][t-coins[i]];
                } 

                dp[i][t] = Math.min(notpick,pick);        
            }
        }
        return dp[n-1][amount]!=INF ? dp[n-1][amount] : -1;
    }
}

// class Solution {
//     static final int INF = 1_000_000_000;

//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[amount+1][n+1];
//         for(int [] row : dp){
//             Arrays.fill(row,INF);
//         }
//         int ans =find(coins,amount,0,dp);
//         if(ans==INF){
//             return -1;
//         }else return ans;

//     }
//     public int find(int[] coins,int amount,int idx,int[][] dp){
//         if(amount==0)return 0;
//         if(idx==coins.length)return INF;

//         if(dp[amount][idx]!=INF)return dp[amount][idx];
//         int pick=INF;
//         if(amount >= coins[idx]){
//             pick = 1 + find(coins,amount-coins[idx],idx,dp);
//         }
//         int notpick = find(coins,amount,idx+1,dp);

//         return dp[amount][idx] =  Math.min(pick,notpick);
//     }
// }









// class Solution {
//     static final int INF = 1_000_000_000;

//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         // Base case: using only coin 0
//         for (int t = 0; t <= amount; t++) {
//             if (t % coins[0] == 0) dp[0][t] = t / coins[0];
//             else dp[0][t] = INF;
//         }

//         // Fill dp table
//         for (int i = 1; i < n; i++) {
//             for (int t = 0; t <= amount; t++) {

//                 // Not pick
//                 int notPick = dp[i - 1][t];

//                 // Pick (unbounded)
//                 int pick = INF;
//                 if (t >= coins[i] && dp[i][t - coins[i]] != INF) {
//                     pick = 1 + dp[i][t - coins[i]];
//                 }

//                 dp[i][t] = Math.min(pick, notPick);
//             }
//         }

//         return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
//     }
// }


// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
 
//         long[][] dp =  new long[n][amount+1];

//         //base case
//         for(int t=0;t<=amount;t++){
//             if(t % coins[0]==0) dp[0][t]= t/coins[0];
//             else dp[0][t] = 1e9;
//         }
//         for(int idx=1;idx<n;idx++){
//             for(int t=0;t<=amount;t++){
//                 int notpick = dp[idx-1][t];
//                 int pick=Integer.MAX_VALUE;
//                 pick = 1 + dp[idx][t-coins[idx]];

//                 dp[idx][t] = Math.min(pick,notpick);
//             }
//         }
//         int ans =dp[n-1][amount];
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }


// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
 
//         long[][] dp =  new long[n][amount+1];
//         for(long[] d : dp){
//             Arrays.fill(d,-1);
//         }
//         long val =find(coins,amount,n-1,dp);
//         return val >= 1e9 ? -1 : (int)val;
//     }

//     public long find(int[] coins, int amount,int idx,long[][] dp){
//         if(idx==0){
//             if(amount%coins[0]==0)return amount/coins[0];
//             return (long) 1e9;
//         }
//         if(amount==0){
//             return 0;
//         }

//         if(dp[idx][amount]!=-1) return dp[idx][amount];
//         long notpick =find(coins,amount,idx-1,dp);
//         long pick=(long)1e9;
//         if(amount>=coins[idx]) pick = 1+ find(coins,amount-coins[idx],idx,dp);

//         return dp[idx][amount] =  Math.min(pick,notpick);
//     }
// }









// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if(amount==0)return 0;
//         int n = coins.length;
//         if(n==0)return -1;

//         int[] dp = new int[amount+1];
//         Arrays.fill(dp,-1);
//         int ans = find(coins, amount, 0, dp);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
//     public int find(int[] coins,int amount,int sum, int[] dp){
//         if(sum>amount)return Integer.MAX_VALUE;;
//         if(sum==amount)return 0;

//         if(dp[sum]!= -1)return dp[sum];
//         int ans =Integer.MAX_VALUE;

//         for(int i=0;i<coins.length;i++){
//             if(coins[i]>amount)continue;
//             int val = find(coins,amount,sum+coins[i],dp);
//             if(val != Integer.MAX_VALUE){
//                 ans = Math.min(ans,1+val);
//             }
//         }
//         return dp[sum] = ans;
//     }
// }




//this does not work bcoz sometime swe need to take small coins only even we have big on e present
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         Arrays.sort(coins);
//         int n=coins.length;
//         int total=0;
//         while(n>0 && amount>0){
//             if(amount>=coins[n-1] ){
//                 int qu=amount/coins[n-1];
//                 int rem=amount%coins[n-1];
//                 amount=rem;
//                 total+=qu;
//             }
//             n--;
//         }
//         if(amount>0)total=-1;
//         return  total;
//     }
// }