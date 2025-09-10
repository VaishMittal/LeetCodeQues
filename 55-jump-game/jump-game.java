// class Solution {
//     public boolean canJump(int[] nums) {

//         int n = nums.length;
//         if(n==1)return true;
//         int idx = n-1;
//         int jumps=nums[0];
//         int i=0;
//         while(i<n){
//             if(jumps-(idx-i) >=0) return true;
//             else{
//                 int temp=jumps;
//                 int flag=0;
//                 while(temp>0){
//                     temp--;
//                     i++;
//                     if(nums[i]>=jumps){
//                         jumps=nums[i];
//                         flag=1;
//                         break;
//                     }else{
//                         if(nums[i]-(n-1-i)>=0){
//                             flag=2;
//                             break;
//                         }
//                     }
//                 }
//                 if(flag==0)jumps=nums[i];
               
//                 if(jumps==0 || flag==2)break;
//             }
//         }
//         if(jumps==0)return false;
//         //else if(flag==2) return true;
//         else return true;

//     }
// }


class Solution {
    public boolean canJump(int[] nums) {
        int n =nums.length;
        int power=0;
        for(int i=0;i<n;i++){
            if(power>=i){
                power=Math.max(power,i+nums[i]);
            }
        }
        if(power>=n-1)return true;
        else return false;
    }
}