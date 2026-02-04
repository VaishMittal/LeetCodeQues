// class Solution {
//     public long maxSumTrionic(int[] nums) {
//         int n = nums.length;
//        return  divide(nums);

//     }
//     public long divide(int[] nums){
//         int n = nums.length;
//         long maxsum=Long.MIN_VALUE;
//           boolean found = false;  
        
//         int i=1;
//         while(i<n){
//             while(i<n && nums[i]==nums[i-1]){
//                 i++;
//             }
//             if(i >= n) break;
//             int start=i-1;
//             int end=0;
//             while(i<n && (nums[i]>nums[i-1] || nums[i]<nums[i-1])){
//             i++;
//             }
//             end=i-1;

//             if(end-start+1 >=4){
//                 long res = findMaxTrio(nums, start, end);
//                 if (res != Long.MIN_VALUE) {
//                     maxsum = Math.max(maxsum, res);
//                       found = true; 
//                 }
//             }
    
//         }
//         return found ? maxsum : 0; 
   
//     }
//     public long findMaxTrio(int[] nums, int start, int end){
//         int n =nums.length;
//         int size =end-start+1;
//         //int[] Point =new int[n];

//         int i=start+1;
//         while(i<=end && nums[i]<=nums[i-1] ){
//             i++;
//         }
//         if(i==end){
//             return Long.MIN_VALUE;
//         }
//         //Point[i-1]=1;
//         ArrayList<Integer> decPoint = new ArrayList<>();
//         int dec=0;
//         int inc=0;
//         for(int j=i;j<=end;j++){
//             if(nums[j]>nums[j-1]){
//                 inc=1;
//                 if(dec==1){
//                    // Point[j-1]=1;
//                     dec=0;
//                 }
//             }else if(nums[j]<nums[j-1]){
//                 dec=1;
//                 if(inc==1){
//                     decPoint.add(j-1);
//                     //Point[j-1]=-1;
//                     inc=0;
//                 }
//             }
//         }
//         int k=0;
//         long maxsum=Long.MIN_VALUE;
//         boolean found = false;

//         for(int t=0;t<decPoint.size();t++){
//             long sum=0;
//             int idx = decPoint.get(t);
//             int decstart=idx;
//             while(idx < end-1 && nums[idx]>nums[idx+1] ){
//                 sum+=nums[idx];
//                 idx++;
//             }
//             int decend=idx;
//             if(decend==end)continue;
//             //left inc valuess
//             if(decstart<=start)continue;
//             long leftsum=0;
//             long leftmax=Long.MIN_VALUE;

//             for(int a=decstart-1;a>start;a--){
//                 if(nums[a] > nums[a-1]){
//                     leftsum+=nums[a];
//                     leftmax=Math.max(leftmax, leftsum);
//                 }else break;
//             }
//             sum+=leftmax;
//             // right inc valuess
//             long rightsum=0;
//             long rightmax=Long.MIN_VALUE;

//             for(int a=decend+1;a<end;a++){
//                 if(nums[a]<nums[a+1]){
//                     rightsum+=nums[a];
//                     rightmax=Math.max(rightmax,rightsum);
//                 }else{
//                     break;
//                 }
//             }

//             sum+=rightmax;
//             if(leftmax != Long.MIN_VALUE && rightmax != Long.MIN_VALUE){
//                 maxsum=Math.max(maxsum,sum);
//                 found=true;
//             }


//         }
//         return found ? maxsum : Long.MIN_VALUE;
//     } 
// }

class Solution {

    public long maxSumTrionic(int[] nums) {
        return divide(nums);
    }

    public long divide(int[] nums) {
        int n = nums.length;
        long maxsum = Long.MIN_VALUE;
        boolean found = false;

        int i = 1;

        while (i < n) {

            // skip equal elements
            while (i < n && nums[i] == nums[i - 1]) i++;
            if (i >= n) break;

            int start = i - 1;

            // build monotonic segment
            while (i < n && (nums[i] > nums[i - 1] || nums[i] < nums[i - 1])) {
                i++;
            }

            int end = i - 1;

            if (end - start + 1 >= 4) {
                long res = findMaxTrio(nums, start, end);
                if (res != Long.MIN_VALUE) {
                    maxsum = Math.max(maxsum, res);
                    found = true;
                }
            }
        }

        return found ? maxsum : 0;
    }

    public long findMaxTrio(int[] nums, int start, int end) {

        long best = Long.MIN_VALUE;
        boolean found = false;

        // try each peak (inc -> dec)
        for (int p = start + 1; p < end; p++) {

            // must be a peak
            if (!(nums[p] > nums[p - 1] && nums[p] > nums[p + 1])) continue;

            // decreasing part
            int q = p;
            long decSum = nums[p];

            while (q < end && nums[q] > nums[q + 1]) {
                q++;
                decSum += nums[q];
            }

            if (q == end) continue;

            // best increasing suffix on the left (EXCLUDING p)
            long leftBest = nums[p - 1];
            long temp = nums[p-1];

            for (int i = p - 1; i > start; i--) {
                if (nums[i] > nums[i - 1]) {
                    temp += nums[i-1];
                    leftBest = Math.max(leftBest, temp);
                } else break;
            }

            // best increasing prefix on the right
            long rightBest = nums[q + 1];
            temp = 0;

            for (int i = q + 1; i <= end; i++) {
                if (nums[i] > nums[i - 1]) {
                    temp += nums[i];
                    rightBest = Math.max(rightBest, temp);
                } else break;
            }

            long total = leftBest + decSum + rightBest;
            best = Math.max(best, total);
            found = true;
        }

        return found ? best : Long.MIN_VALUE;
    }
}
