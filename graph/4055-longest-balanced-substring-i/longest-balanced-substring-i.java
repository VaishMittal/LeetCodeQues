class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxlen=0;

        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            int maxfreq=0;
            int distinct=0;
            for(int j=i;j<n;j++){
                int idx = s.charAt(j)-'a';
                if(freq[idx]==0){
                    distinct++;
                }
                freq[idx]++;
                int len=j-i+1;
                maxfreq=Math.max(maxfreq,freq[idx]);
                if(len==maxfreq*distinct){
                    maxlen=Math.max(maxlen,len);
                }
            }
        }
        return maxlen;
        
    }
}