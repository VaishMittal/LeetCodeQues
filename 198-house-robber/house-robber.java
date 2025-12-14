class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return find(nums,0,dp);
    }
    public int find(int[] arr, int idx,int[] dp){
        if(idx>=arr.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        return dp[idx] = Math.max( arr[idx] + find(arr,idx+2,dp),find(arr,idx+1,dp));
    }
}










// class Solution {
//     public int rob(int[] nums) {
//         int n =nums.length;
//         int ways=0;
//         if(n==1)return nums[0];
//         if(n==2)return Math.max(nums[0],nums[1]);

//         int a=nums[n-1];
//         int b=nums[n-2];
//         int c=0;
//         for(int i=n-3;i>=0;i--){
//             c =nums[i]+a;
//             a=Math.max(a,b);
//             b=c;
//         }
//         return Math.max(a,Math.max(b,c));
//     }
// }