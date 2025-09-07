class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            int idx=map.get(i);
            if(idx>(n/2)){
                ans=i;
            }
        }
        return ans;
        // Arrays.sort(nums);
        // return nums[n/2];
    }
}