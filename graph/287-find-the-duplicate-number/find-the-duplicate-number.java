class Solution {
    public int findDuplicate(int[] nums) {
        int n =nums.length;
        int[] ar = new int[n];
        ar[0]=1;
        for(int i=0;i<n+1;i++){
            if(ar[nums[i]]==0)ar[nums[i]]=1;
            else return nums[i];
        }
        return 0;

    }
}