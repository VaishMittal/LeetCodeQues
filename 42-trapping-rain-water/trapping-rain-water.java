class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxl=arr[0];
        int maxr=arr[n-1];
        for(int i=0;i<n;i++){
            maxl = Math.max(maxl,arr[i]);
            left[i]=maxl;
        }
        for(int i=n-1;i>=0;i--){
            maxr = Math.max(maxr,arr[i]);
            right[i]=maxr;
        }
        int count=0;
        for(int i=0;i<n;i++){
            count+=(Math.min(left[i],right[i])-arr[i]);
        }
        return count;
    }
}

// class Solution {
//     public int trap(int[] arr) {
//         int n=arr.length;
//         int start=-1;
//         int end=-1;
//         int i=1;
//         int units=0;
//         while(i<n && arr[i]>arr[i-1])i++;
//         start=i-1;
//         while(i<n){
//             while(i<n && arr[i]<arr[i-1])i++;
//             while(i<n && arr[i]>arr[i-1] )i++;
//             end=i-1;
//             int mini=Math.min(arr[start],arr[end]);
//             for(int j=start+1;j<end;j++){
//                 units+= (mini - arr[j]);
//             }
//             start=end;
//         }
//         return units;
//     }
// }