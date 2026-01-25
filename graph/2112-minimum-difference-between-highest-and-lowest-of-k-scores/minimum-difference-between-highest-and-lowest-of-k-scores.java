class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1)return 0;
        int n = nums.length;
        if(k>n)return -1;
        Arrays.sort(nums);
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<n-(k-1);i++){
            mindiff = Math.min(mindiff, nums[i+k-1]-nums[i]);
        }
        return mindiff;
    }
}