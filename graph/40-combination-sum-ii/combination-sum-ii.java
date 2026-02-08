class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        find(nums,target,ans,new ArrayList<>(),0);
        return ans;
    }
    public void find(int[] nums, int target, List<List<Integer>> ans ,List<Integer> cur, int idx){
        if(target==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(target<0 || idx==nums.length)return;
        if(nums[idx]>target)return;

        //pick
        cur.add(nums[idx]);
        find(nums,target-nums[idx],ans,cur,idx+1);
        cur.remove(cur.size()-1);
        int next=idx+1;
        //skipping duplicates
        while(next<nums.length && nums[next]==nums[idx])next++;
        //notpick
        find(nums,target,ans,cur,next);

    }
}