class Solution {
    public List<String> buildArray(int[] target, int n) {
        int k=0;
        int len=target.length;
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(k<len && i==target[k]){
                k++;
                ans.add("Push");
                if(k==len)break;
            }else{
                ans.add("Push");
                ans.add("Pop");
            }
            
        }
        return ans;
    }
}