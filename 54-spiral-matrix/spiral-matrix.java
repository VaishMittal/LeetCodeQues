class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int n =arr.length;
        int m =arr[0].length;
        int lastcol=m;
        int lastrow=n;
        int firstrow=0;
        int firstcol=0;
        List<Integer> ans = new ArrayList<>();
        int count=m*n;
        while(count>0){
        for(int i=firstcol;i<lastcol && count>0;i++){
            ans.add(arr[firstrow][i]);
            count--;
        }
        firstrow++;
        for(int i=firstrow;i<lastrow  && count>0;i++){
            ans.add(arr[i][lastcol-1]);
            count--;
        }
        lastcol--;
        for(int i=lastcol-1;i>=firstcol  && count>0;i--){
            ans.add(arr[lastrow-1][i]);
            count--;
        }
        lastrow--;
        for(int i=lastrow-1;i>=firstrow  && count>0;i--){
            ans.add(arr[i][firstcol]);
            count--;
        }
        firstcol++;
        }

        return ans;
    }

}