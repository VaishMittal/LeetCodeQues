class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        return Math.max(find(nums,0,n-1,dp), find(nums,1,n,dp2));
    }
    public int find(int[] arr, int idx,int end,int[] dp){
        if(idx>=end)return 0;
        if(dp[idx]!=-1)return dp[idx];
        return dp[idx] = Math.max( arr[idx] + find(arr,idx+2,end,dp),find(arr,idx+1,end,dp));
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