class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start=0;
        int end=0;
        int[] arr = new int[128];
        int maxi=0;
        Arrays.fill(arr,0);
        while(end<n){
            if(arr[s.charAt(end)-0]==0){
                arr[s.charAt(end)-0]=1;
                end++;
            }else{
                while(s.charAt(start)!=s.charAt(end)){
                    arr[s.charAt(start)-0]=0;
                    start++;
                }
                start++;
                end++;
            }
            maxi=Math.max(maxi,end-start);
        }
        return maxi;
    }
}