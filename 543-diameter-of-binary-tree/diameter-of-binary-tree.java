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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        find(root, maxi);
        return maxi[0];
    }

    public int find(TreeNode node, int[] maxi) {
        if (node == null)
            return 0;
        int lh = find(node.left, maxi);
        int rh = find(node.right, maxi);
        maxi[0] = Math.max(maxi[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}