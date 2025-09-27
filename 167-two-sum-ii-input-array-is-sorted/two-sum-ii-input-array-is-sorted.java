class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        int[] ans = new int[2];
        while(start<=end){
            if(numbers[start]+numbers[end]==target){
                ans[0]=start+1;
                ans[1]=end+1;
                break;
            }else if(numbers[start]+numbers[end]>target){
                end--;
            }else{
                start++;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int n = numbers.length;
//         int start=0;
//         int end=0;

//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(numbers[i]+numbers[j]==target){
//                     start=i+1;
//                     end=j+1;
//                     break;
//                 }
//             }
//         }
//         int[] ans = {start,end};
//         return  ans;
//     }
// }
