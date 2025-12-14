class Solution {
    public int numDecodings(String s) {
        int[]dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return find(s,0,dp);
        
    }
    public int find(String s ,int idx,int[]dp){
        if(idx==s.length())return 1;
        if(idx>s.length() || s.charAt(idx)=='0')return 0;
        if(dp[idx]!=-1)return dp[idx];
        int ways=0;

        ways += find(s,idx+1,dp);
        
        if(idx+2<=s.length()){
            int num = Integer.parseInt(s.substring(idx,idx+2));
            if(num<=26){
                ways+=find(s,idx+2,dp);
            }
        }
        return dp[idx] = ways;
    }
}