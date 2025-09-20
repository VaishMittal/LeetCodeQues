class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m = needle.length();
        if(m>n)return -1;
        if(haystack.equals(needle)) return 0;
        int ans=-1;
        for(int i=0;i<=n-m;i++){
            String hay = haystack.substring(i);
            if(hay.startsWith(needle)){
                ans=i;
                break;
            }

        }
        return ans;
    }
}