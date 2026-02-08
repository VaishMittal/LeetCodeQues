class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        find(nums,ans,0,new ArrayList<>());
        return ans;
    }
    public void find(int[] nums,List<List<Integer>> ans, int idx,List<Integer> cur){
        int n =nums.length;
        ans.add(new ArrayList<>(cur));
        
        for(int i=idx;i<n;i++){
            if(i!=idx && nums[i]==nums[i-1])continue;
            cur.add(nums[i]);
            find(nums,ans,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}