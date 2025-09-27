class Solution {
    public int maxArea(int[] arr) {
        int n= arr.length;
        if(n==1 || n==0)return 0;
        if(n==2){
            return Math.min(arr[0],arr[1])*Math.min(arr[0],arr[1]);
        }
        int start=0;
        int end = n-1;
        int ans=-1;
        while(start<end){
            int mini=Math.min(arr[start],arr[end]);
            ans=Math.max(ans,mini*(end-start));
            if(arr[start]>=arr[end]){
                int val=arr[end];
                end--;
                while(val>=arr[end] && end>start) end--;
            }else{
                int val =arr[start];
                start++;
                while(val>=arr[start] && start<end)start++;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int maxArea(int[] arr) {
//         int n= arr.length;
//         if(n==1 || n==0)return 0;
//         if(n==2){
//             return Math.min(arr[0],arr[1])*Math.min(arr[0],arr[1]);
//         }
//         int ans=-1;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 int mini=Math.min(arr[i],arr[j]);
//                 ans=Math.max(ans,mini*(j-i));
//             }
//         }
//         return ans;
//     }
// }