class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mini=Integer.MAX_VALUE;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(prices[i]<mini) mini=prices[i];
            maxi=Math.max(maxi,prices[i]-mini);
        }
        return maxi;
    }
}



//  int maxi=0;
//         int n = prices.length;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(prices[j]>prices[i]){
//                     int profit=prices[j]-prices[i];
//                     maxi=Math.max(maxi,profit);
//                 }
//             }
//         }
//         return maxi;
