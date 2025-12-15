class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int c=0;
        int mini=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                c++;
                mini++;
                maxi++;
            }else if(s.charAt(i)==')'){
                c--;
                mini--;
                maxi--;
            }else{
               mini--;
               maxi++;
            }
            if(mini<0)mini=0;
            if(maxi<0)return false;
        }
        if(mini==0)return true;
        else return false;
    }
}