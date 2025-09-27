class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n==0)return true;
        if(s==t)return true;
        if(n>m)return false;
        if(n==m && s!=t)return false;
        int small=0;
        int large=0;
        int found=0;
        while(m>0){
            if(s.charAt(small)==t.charAt(large)){
                small++;
                large++;
                found++;
            
            }else{
                large++;
                
            }
            m--;
            if(found==n)break;
        }
        return found==n;

    }
}
