class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;

        //first we will transpose our matrix arr
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(arr,i,j);
            }
        }

        //now we reverse each row
        for(int i=0;i<n;i++){
            rotate(arr[i]);
        }

        
    }
    public void swap(int[][] arr,int s,int e){
        int temp=arr[s][e];
        arr[s][e] = arr[e][s];
        arr[e][s] = temp;
    }

    public void rotate(int[] row){
        int s=0;
        int e=row.length-1;;
        while(s<e){
            int temp = row[s];
            row[s] = row[e];
            row[e] = temp;
            s++;
            e--;
        }
    }
}