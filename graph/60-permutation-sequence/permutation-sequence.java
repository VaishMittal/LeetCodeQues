class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int [] fact =new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
            nums.add(i);
            fact[i]=fact[i-1]*i;
        }
        StringBuilder ans =new StringBuilder();
        find(fact,nums,k-1,ans,n);
        return ans.toString();
    }
    public void find(int[] fact, List<Integer> nums, int k, StringBuilder ans, int n){
        if(n==0)return;
        int val=fact[n] / n; // each same start value permutaions
        int idx=k / val;
        ans.append(nums.get(idx));
        nums.remove(idx);
        find(fact,nums,k%val,ans,n-1);

    }
}