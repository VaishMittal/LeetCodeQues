class Solution {
    public String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        if(n==1)return arr[0];
        if(n==0)return "";
        String first = arr[0];
        int maxi = 0;
        int mini=Math.min(arr[1].length(),first.length());
        for(int i=1;i<n;i++){
            String a = arr[i];
            mini=Math.min(a.length(),mini);
            maxi=0;
            for(int j=0;j<mini;j++){
                if(a.charAt(j)==first.charAt(j)){
                    maxi++;
                }else break;
            }
            mini=maxi;
        
        }
        if(maxi>0)return first.substring(0,maxi);
        else return "";
    }
}