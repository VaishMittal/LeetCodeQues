class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[] mini=new int[n];
        int[] maxi=new int[n];

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(nums[i],min);
            mini[i]=min;
        }
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max=Math.max(nums[i],max);
            maxi[i]=max;
        }

        int maxp=0;
        for(int i=0;i<n;i++){
            maxp=Math.max(maxp,maxi[i]-mini[i]);
        }
        return maxp;
    }
}