/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);

        return balanceTree(list,0,list.size()-1);
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null)return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode balanceTree(List<Integer> list, int start, int end){
        if(start> end)return null;

        int mid=(start+end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balanceTree(list,start,mid-1);
        root.right = balanceTree(list,mid+1,end);

        return root;
    }
}