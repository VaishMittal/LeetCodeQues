class Solution {
    public void nextPermutation(int[] nums) {
        int n =nums.length;
        int cur=0;
        int idx=0;
        int flag=0;
        int mini=Integer.MAX_VALUE;
        for(int i=n-2;i>=0;i--){
            if(i==n-2 && nums[i]<nums[i+1]){
                //simply swap
                int temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
                return;
            }
            else if(nums[i]>=nums[i+1]){
                continue;
            }else{
                flag=1;
                cur=i;
                for(int j=cur+1;j<n;j++){
                    if(nums[j]>nums[cur] && mini>nums[j]){
                        mini=nums[j];
                        idx=j;
                    }
                }
                //now swap cur idx value with min value idx;
                int temp = nums[cur];
                nums[cur] = nums[idx];
                nums[idx]=temp;
                //now sort all arr after cur;
                int newn=n-(cur+1);
                int[] newar= new int[newn];
                for(int j=0;j<newn;j++){
                    newar[j]=nums[j+cur+1];
                }
                Arrays.sort(newar);
                int l=0;
                for(int j=cur+1;j<n;j++){
                    nums[j]=newar[l++];
                }
                return;
            }
        }
        if(flag==0)Arrays.sort(nums);
    }
}