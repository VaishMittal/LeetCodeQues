class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n==1)return 0;
        Arrays.sort(nums);

        int l=0;
        int r=0;
        int maxi=0;
        while(l<n){
            while(r<n && nums[r] <= (long)nums[l]*k){
                r++;
            }
            maxi=Math.max(maxi,r-l);
            l++;
        }
        int ans=n-maxi;
        return ans;
    }
}



