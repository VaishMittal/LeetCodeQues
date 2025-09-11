class Solution {
    public int jump(int[] nums) {

        int n =nums.length;
        if(n==1)return 0;
        int maxreach=nums[0];
        int minsteps=1;
        int boundary=nums[0];
        for(int i=1;i<n-1;i++){
            if(nums[i]+i > maxreach){
                maxreach=nums[i]+i;
            }
            if(i==boundary){
                boundary=maxreach;
                minsteps++;
            }
        }
        return minsteps;
    }
}