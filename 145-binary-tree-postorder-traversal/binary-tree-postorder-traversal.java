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
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root==null)return ans;
//         if(root.left== null && root.right==null) {
//             ans.add(root.val);
//             return ans;
//         }
//         postOrder(root,ans);
//         return ans;
//     }
//     public void postOrder(TreeNode node,List<Integer> ans){
//         if(node==null) return;

//         postOrder(node.left,ans);
//         postOrder(node.right,ans);
//         ans.add(node.val);
//     }
// }



class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        if(root==null)return ans;
        if(root.left== null && root.right==null) {
            ans.add(root.val);
            return ans;
        }
        //using two stack
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode top = st1.pop();
            st2.push(top);
            if(top.left!=null)st1.push(top.left);
            if(top.right!=null)st1.push(top.right);
        }
        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }

        return ans;
    }
   
}