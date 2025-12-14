class Solution {
    public int[][] insert(int[][] arr, int[] interval) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i=0;
        int n = arr.length;
        while(i<n && arr[i][1]<interval[0]){
            list.add(new ArrayList<>());
            list.get(i).add(arr[i][0]);
            list.get(i).add(arr[i][1]);
            i++;
        }
        int mini = interval[0];
        int maxi = interval[1];
        while(i<n && maxi>=arr[i][0]){
            mini=Math.min(mini,arr[i][0]);
            maxi=Math.max(maxi,arr[i][1]);
            i++;
        }
        list.add(new ArrayList<>());
        list.get(list.size()-1).add(mini);
        list.get(list.size()-1).add(maxi);

        while(i<n){
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(arr[i][0]);
            list.get(list.size()-1).add(arr[i][1]);
            i++;
        }
        //return list.toArray(new int[list.size()][]);
        int m = list.size();
        int[][] ans = new int[m][2];
        for(int j=0;j<m;j++){
            ans[j][0]=list.get(j).get(0);
            ans[j][1]=list.get(j).get(1);
        }
        return ans;
    }
}













// class Solution {
//     public int[][] insert(int[][] arr1, int[] newInterval) {
//       int n = arr1.length;
//       List<int[]> list = new ArrayList<>();
//       for(int[] x:arr1){
//         list.add(x);
//       }
//       list.add(newInterval);
//      int[][] arr = list.toArray(new int[list.size()][]);
//       Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
//       List<int[]> ans = new ArrayList<>();
//       int start=arr[0][0];
//       int end=arr[0][1];
     
//       for(int i=1;i<arr.length;i++){
//         if(arr[i][0]<=end){
//             end=Math.max(end,arr[i][1]);
//         }else{
//             ans.add(new int []{start,end});
//             start=arr[i][0];
//             end=arr[i][1];
//         }
//       }
//         ans.add(new int []{start,end});

//       return ans.toArray(new int[ans.size()][]);

        
//     }
// }