class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n =nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            map.putIfAbsent(nums[i],1);
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer x : map.keySet()){
            if(map.get(x)>n/3){
                ans.add(x);
            }
        }
        return ans;
    }
}