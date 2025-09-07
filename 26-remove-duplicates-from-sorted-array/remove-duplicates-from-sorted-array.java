class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int p=1;
        int c=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                c++;
                continue;}
            nums[p]=nums[i];
            p++;
        }
        return n-c;
    }
}