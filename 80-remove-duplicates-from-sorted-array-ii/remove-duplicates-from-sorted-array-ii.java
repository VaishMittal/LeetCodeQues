class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n<=2)return n;
        int p=2;
        for(int i=2;i<n;i++){
            if(nums[i]!=nums[p-2]){
                nums[p]=nums[i];
                p++;
            }
        }
        return p;
    }
}