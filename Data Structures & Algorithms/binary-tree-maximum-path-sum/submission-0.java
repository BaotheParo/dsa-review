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
    private int maxSum= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        caculatorMaxGain(root);
        return maxSum;
    }
    public int caculatorMaxGain(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftGain = Math.max(0, caculatorMaxGain(node.left));
        int rightGain = Math.max(0, caculatorMaxGain(node.right));
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}
