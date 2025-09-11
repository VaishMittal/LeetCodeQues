class Solution {
    public int hIndex(int[] arr) {
        int n =arr.length;
        int maxh=0;
        
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int c = n-i;
            if(arr[i]>=c){maxh=c;
            break;}
        }
        return maxh;
    }
}