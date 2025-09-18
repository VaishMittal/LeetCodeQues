class Solution {
    public String convert(String s, int rows) {
        int n=s.length();
        if(n<=rows)return s;
        if(rows==1)return s;
        StringBuilder ans= new StringBuilder("");
        for(int i=0;i<rows;i++){
            ans.append(s.charAt(i));
            int idx=i;
            int add=(rows-i)*2-2;
            int var=i*2;
            if(i==rows-1)add=rows*2-2;
            while(idx<n){
                idx+=add;
                if(idx>=n)break;
              ans.append(s.charAt(idx));
                
                if(i!=0 && i!=rows-1){
                    idx+=var;
                    if(idx>=n)break;
                    ans.append(s.charAt(idx));
                }
            }

        }
        return ans.toString();
    }
}