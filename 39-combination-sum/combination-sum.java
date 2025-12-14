class Solution {
    static  List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        ArrayList<Integer> list = new ArrayList<>();
        find(candidates,target,0,0,list);
        return ans;
    }
    public void find(int[] arr, int target, int sum,int idx, ArrayList<Integer> list ){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx==arr.length || sum>target)return;

        //notpick
        find(arr,target,sum,idx+1,list);

        //pick
        if(arr[idx]<=target){
            list.add(arr[idx]);
            find(arr,target,sum+arr[idx],idx,list);
            list.remove(list.size()-1);
        }

    }
}