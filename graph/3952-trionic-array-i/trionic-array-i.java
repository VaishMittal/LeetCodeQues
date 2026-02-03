class Solution {
    public boolean isTrionic(int[] nums) {
        int n =nums.length;
        if (nums[1]<=nums[0] || n<4 ) return false;
        int dec=0;
        int inc=0;
        for(int i=2;i<n;i++){
            if(nums[i]==nums[i-1])return false;
            if(nums[i]<nums[i-1]){
                dec=1;
                if(inc==2)return false;
            }else{
                if(dec==0)inc=1;
                else inc=2;
            }
        }
        if(inc==2)return true;
        return false;
        
    }
}
