class Solution {
    public int minimumDeletions(String s) {
        int n =s.length();
        if(n==1)return 0;
        int[] acount =new int[n];
        int[] bcount =new int[n];
        int l=1;  
        int r=n-2;
        if(s.charAt(0)=='a'){
            acount[0]=1;
        }
        if(s.charAt(n-1)=='b'){
            bcount[n-1]=1;
        }
      
        while(l<n){
            if(s.charAt(l)=='a'){
                acount[l]=acount[l-1]+1;
            }else{
                acount[l]=acount[l-1];
            }
            l++;
        }
        while(r>=0){
            if(s.charAt(r)=='b'){
                bcount[r]=bcount[r+1]+1;
            }else{
                bcount[r]=bcount[r+1];
            }
            r--;
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int val=n-(acount[i]+bcount[i]);
            mini=Math.min(mini,val);
        }
        return mini;
        
    }
}


// class Solution {
//     public int minimumDeletions(String s) {
//         int n =s.length();
//         int l=0;
//         int r=n-1;
//         int bcount=0;
//         int acount=0;
//         while(l<n && s.charAt(l)=='a'){
//             l++;
//         }
//         if(l==n)return 0;
//         while(r>=0 && r>l && s.charAt(r)=='b' ){
//             r--;
//         }
//         while(l<=r){
//             if(s.charAt(l)=='a')acount++;
//             else bcount++;
//             l++;
//         }
//         return Math.min(acount,bcount);
//     }
// }