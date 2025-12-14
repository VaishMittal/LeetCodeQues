class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()]; 
        return find(s,wordDict,0,dp);
    }
    public boolean find(String s, List<String> dict, int idx,Boolean[] dp){
        if(idx>=s.length())return true;

        if(dp[idx] != null)return dp[idx];
        for(int i=0;i<dict.size();i++){
            String dictstr = dict.get(i);
            if(s.startsWith(dictstr,idx)) {
                if(find(s,dict,idx+dictstr.length(),dp)) return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}



















// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Boolean[] dp =new Boolean[s.length()];
//         return find(s,wordDict,0,dp);
//     }
//     public boolean find(String s,List<String> wordDict, int idx, Boolean[] dp){
//         if(idx==s.length()) return true;

//         if(dp[idx]!=null)return dp[idx];

//         for(String str : wordDict){
//             if((idx+str.length()) <= s.length() &&  s.startsWith(str,idx)) {

//                 if(find(s,wordDict,idx+str.length(),dp))
//                  return dp[idx] = true;
//             }
//         }
//         return dp[idx] = false;
//     }
// }