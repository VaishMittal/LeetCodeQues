class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int n =prices.length;
        int i=0;
       
        while(i<n-1){
            if(prices[i+1]>prices[i]){
                 profit+=prices[i+1]-prices[i];
                 i++;
                 }
            else i++;
        }
        return profit;
    }
}