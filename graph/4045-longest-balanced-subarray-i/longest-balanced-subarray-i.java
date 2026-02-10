class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxlen=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> odd = new HashSet<>();
            HashSet<Integer> even = new HashSet<>();
            for(int j=i;j<n;j++){
                if(nums[j]%2==0)even.add(nums[j]);
                else{
                    odd.add(nums[j]);
                }
                if(even.size()==odd.size()){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
}

// class Solution {
//     public int longestBalanced(int[] nums) {
//         int n = nums.length;
//         int[] even = new int[n];
//         int[] odd = new int[n];
//         if(nums[0]%2==0)even[0]=1;
//         else{odd[0]=1;}
//         HashMap<Integer> map = new HashMap<>();
//         map.put(nums[0],1);
//         for(int i=1;i<n;i++){
//             if(map.contaisKey(nums[i])) {
//                 even[i]=even[i-1];
//                 odd[i]=odd[i-1];
//                 continue;
//             }
//             if(nums[i]%2==0){
//                 even[i]=even[i-1]+1;
//                 odd[i]=odd[i-1];
//             }else{
//                 odd[i]=odd[i-1]+1;
//                 even[i]=even[i-1];
//             }
//         }
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){

//             }
//         }
//     }
// }
//      3  2  2  5  4
// even 0  1  1  1  2
// odd  1  1  1  2  2

//      1  2  3  2
// even 0  1  1  1
// odd  1  1  2  2