class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        if (n==1)return 1;
        int len=0;
        int i=n-1;
        while(i>=0 && s.charAt(i)==' ')i--;
        while(i>=0 && s.charAt(i)!=' '){
            i--;
            len++;
        }
        return len;
    
    }
}