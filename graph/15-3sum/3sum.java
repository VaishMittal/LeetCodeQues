class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n<3)return ans;
        Arrays.sort(nums);
        int l=1;
        int r=n-1;
        int first=nums[0];

        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1] )continue;
            if(nums[i]>0)break;
            first=nums[i];
            l=i+1;
            r=n-1;
            while(l<r){
                int sum=nums[l]+nums[r];
                if(l<r && first+sum==0){
                    ans.add(Arrays.asList(first, nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }else if(l<r && first+sum>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}