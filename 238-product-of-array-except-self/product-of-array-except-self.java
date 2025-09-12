class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int ans[] = new int[n];

        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        int suffix=1;
        for(int i=n-1;i>=0;i--){
            ans[i]*=suffix;
            suffix*=nums[i];
        }
        return ans;
    }
}

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n =nums.length;
//         int front[]= new int[n];
//         int back[] = new int[n];
//         int ans [] = new int[n];
//         front[0]=nums[0];
//         for(int i=1;i<n;i++){
//             front[i]=front[i-1]*nums[i];
//         }
//         back[n-1]=nums[n-1];
//         for(int i=n-2;i>=0;i--){
//             back[i]=back[i+1]*nums[i];
//         }
//         int first=1;
//         int last=1;
//         for(int i=0;i<n;i++){
//             if(i==0) first = 1;
//             else first = front[i-1];

//             if(i==n-1)last=1;
//             else last = back[i+1];

//             ans[i]=first*last;
//         }
//         return ans;
       
//     }
// }