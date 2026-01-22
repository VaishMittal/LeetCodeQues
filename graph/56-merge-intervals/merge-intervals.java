class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<int[]> l = new ArrayList<>();
        int n = arr.length;
        int mini=arr[0][0];
        int maxi=arr[0][1];
        for(int i=1;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            if((start>=mini && start<=maxi) || (end>=mini && end<=maxi) ){
                mini=Math.min(mini,start);
                maxi=Math.max(maxi,end);
            }else{
                l.add(new int[]{mini,maxi});
                mini=arr[i][0];
                maxi=arr[i][1];
            }
        }
        l.add(new int[]{mini,maxi});
        int size=l.size();
        int[][] ans =new int[size][2];
        for(int i=0;i<size;i++){
            ans[i]=l.get(i);
        }
        return ans;
    }
}