class Solution {
    public int candy(int[] arr) {
        int n=arr.length;
        int[] cnd = new int[n];
        Arrays.fill(cnd,1);
        for(int i=1;i<n;i++){

            if(arr[i-1]>arr[i]  && cnd[i-1]<=cnd[i])
                cnd[i-1]=cnd[i]+1;
                
            else if(arr[i]>arr[i-1] && cnd[i]<=cnd[i-1])
                cnd[i]=cnd[i-1]+1;

            else  continue;

        }
        for(int i=n-2;i>=0;i--){

            if(arr[i+1]>arr[i]  && cnd[i+1]<=cnd[i])
                cnd[i+1]=cnd[i]+1;
                
            else if(arr[i]>arr[i+1] && cnd[i]<=cnd[i+1])
                cnd[i]=cnd[i+1]+1;

            else  continue;

        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=cnd[i];
        }
        return sum;
    }
}