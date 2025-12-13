class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
     
        for(int cur=n-1;cur>=0;cur--){
            for(int prev=cur-1;prev>=-1;prev--){
                int notpick = dp[cur+1][prev+1];
                int pick=0;
                if(prev==-1 || arr[cur]>arr[prev]){
                    pick=1+dp[cur+1][cur+1];
                }
                dp[cur][prev+1] = Math.max(pick,notpick);
            }
        }

        return dp[0][0];
    }
}
//     public int find(int[] arr, int idx, int prev,int[][] dp){
//         if(idx==arr.length-1){
//             if(prev==-1 || arr[prev]<arr[idx])return 1;
//             else return 0;
//         }
//         if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
//         int notpick = find(arr,idx+1,prev,dp);//not  pick
//         int pick=0;
//         if(prev==-1 || arr[prev]<arr[idx]){
//             pick = 1+ find(arr,idx+1,idx,dp);
//         } //pick

//         return dp[idx][prev+1] =  Math.max(pick,notpick);

//     }
// }











// class Solution {
//     public int lengthOfLIS(int[] arr) {
//         int n = arr.length;
//         int[] dp = new int[n];
//         int maxi=1;
//         Arrays.fill(dp,1);
//         for(int i=0;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(arr[i]>arr[j]){
//                     dp[i]=Math.max(dp[i],1+dp[j]);
//                 }
//             }
//             maxi=Math.max(maxi,dp[i]);
//         }
//         return maxi;
//     }
// }

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n+1];
//         for(int[] ar : dp){
//             Arrays.fill(ar,-1);
//         }
//         int idx=0;
//         int prevIdx=-1;
//         return find(idx,prevIdx,nums,dp);
//     }
//     public int find(int idx,int prevIdx,int[] arr,int[][] dp){
//         if(idx==arr.length)return 0;

//         if(dp[idx][prevIdx+1]!=-1)return dp[idx][prevIdx+1];
//         int notTake = find(idx + 1, prevIdx, arr, dp);
//         int take = 0;

//         if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
//             take = 1 + find(idx + 1, idx, arr, dp);
//         }

//         return dp[idx][prevIdx + 1] = Math.max(notTake, take);
//     }
// }