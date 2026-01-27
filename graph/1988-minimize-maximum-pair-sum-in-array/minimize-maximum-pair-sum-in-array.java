class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxi=Integer.MIN_VALUE;
        int n =nums.length;
        int k=n-1;
        for(int i=0;i<n/2;i++){
            maxi=Math.max(maxi,nums[i]+nums[k]);
            k--;
        }
        return maxi;
    }
}