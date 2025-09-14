class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int travelled = 0;
        int leftgas = 0;
        int i = 0;
        int totalGas = 0, totalCost = 0;

        // quick check: if total gas < total cost → impossible
        for (int k = 0; k < n; k++) {
            totalGas += gas[k];
            totalCost += cost[k];
        }
        if (totalGas < totalCost) return -1;

        while (start < n && travelled < n) {
            if (gas[i] + leftgas >= cost[i]) {
                leftgas = leftgas + gas[i] - cost[i];
                travelled++;
                i = (i + 1) % n;
            } else {
                // failed → move start forward
                start = i + 1;
                i = start;
                travelled = 0;
                leftgas = 0;
            }
        }

        return (travelled == n) ? start : -1;
    }
}


// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int start = 0; //potential start
//         int travelled=0; //station travelled
//         int n = gas.length;
//         int leftgas=0;
//         int i=0;

//         while(start<n && travelled<n){
//             if(gas[i]+leftgas >= cost[i] ){
//                 i=(i+1)%n;
//                 travelled++;
//                 leftgas=(leftgas+gas[i])-cost[i];
//             }else{
                
//                 start=i+1;
//                 i=start;
//                 travelled=0;
//                 leftgas=0;

//             }
            
//         }
//         if(travelled==n)return start;
//         return -1;

//     }
// }
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int leftgas=0;
//         int n=gas.length;
//         int pos = n;
//         int notpos = n;
//         int flag=0;
//         int c=0;
//         int idx=-1;
//         while(pos>0 && notpos>0){
//             for(int i=0;i<n;i++){
//                 if(cost[i]>gas[i]+leftgas){
//                     if(flag==1){
//                         // notpos=n-1;
//                         // pos=n;
//                         // flag=0;
//                         // c=0;
//                         notpos=0;
//                         break;
//                     }else notpos--;
//                 }else{
//                     flag=1;
//                     c+=1;
//                     if(c==1)idx=i;
//                     leftgas=( leftgas + gas[i])-cost[i];
//                     pos--;
//                 }
//             }  
//         }
//         if(notpos==0)return -1;
//         else return idx;
        
       
//     }
// }