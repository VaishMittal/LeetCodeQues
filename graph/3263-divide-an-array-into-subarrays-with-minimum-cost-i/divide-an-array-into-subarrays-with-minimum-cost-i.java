class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int[] ar = new int[n-1];
        for(int i=0;i<n-1;i++){
            ar[i]=nums[i+1];
        }
        Arrays.sort(ar);
        int sum=nums[0];
        for(int i=0;i<2;i++){
            sum+=ar[i];
        }
        return sum;
    }
}