class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        if(k==0)return;
        int[]last = new int[n-k];
        int[] first = new int[k];
        for(int i=0;i<n;i++){
            if(i<n-k)
            last[i]=nums[i];
            else first[i-(n-k)]=nums[i];
        }
        for(int i=0;i<n;i++){
            if(i<k)
            nums[i]=first[i];
            else nums[i]=last[i-k];
        }
    }
}