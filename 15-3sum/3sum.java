class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        if(n<=2)return ans;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int start=i+1;
            int end=n-1;
            if(i>0 && nums[i]==nums[i-1])continue;
           
            while(start<end){
                if (nums[i]+nums[start]+nums[end]==0){
                    List<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[start]);
                    inner.add(nums[end]);
                    ans.add(inner);
                    start++;
                    end--;
                    while(start<end && nums[start]==nums[start-1])start++;
                    while(start<end && nums[end]==nums[end+1])end--;
                }
                else if  (nums[i]+nums[start]+nums[end]<0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return ans;
    }
}

