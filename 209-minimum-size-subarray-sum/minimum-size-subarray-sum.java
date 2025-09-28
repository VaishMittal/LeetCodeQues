class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int n = nums.length;
        int minSub=Integer.MAX_VALUE;
        int sum=0;
        int flag=0;
        while(end<n){
            sum+=nums[end];
            end++;
            // if(sum>=target){
                // minSub=Math.min(minSub,end-start);
                while(sum>=target){
                    flag=1;
                    minSub=Math.min(minSub,end-start);
                    sum-=nums[start];
                    start++;
                }

        }
        if(flag==0){
            minSub=0;
        }
        return minSub;
    }
}