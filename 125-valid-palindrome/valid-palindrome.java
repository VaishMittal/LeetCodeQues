class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s.length()==1)return true;
        int n= s.length();
        StringBuilder a =new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))a.append(ch);
        }
        return a.toString().toLowerCase().equals(a.reverse().toString().toLowerCase());

    }
}