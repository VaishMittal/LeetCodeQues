class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int mini=Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            mini=Math.min(mini,arr[i+1]-arr[i]);
        }
        for(int i=0;i<n-1;i++){
            if(mini== arr[i+1]-arr[i]){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }

        }
        return ans;
    }
}