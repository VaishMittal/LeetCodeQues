class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n =nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums2[j]>nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        int m = nums1.length;
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            ans[i]=map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}