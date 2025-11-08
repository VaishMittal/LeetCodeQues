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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        if(root.left== null && root.right==null) {
            ans.add(root.val);
            return ans;
        }
        postOrder(root,ans);
        return ans;
    }
    public void postOrder(TreeNode node,List<Integer> ans){
        if(node==null) return;

        postOrder(node.left,ans);
        postOrder(node.right,ans);
        ans.add(node.val);
    }
}