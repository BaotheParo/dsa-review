/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Điều kiện dừng: Nếu cây rỗng hoặc đi đến lá tận cùng
        if (root == null) {
            return null;
        }

        // Tạm giữ con bên trái lại trước khi tráo đổi
        TreeNode temp = root.left;
        
        // Tiến hành tráo đổi (Swap) hai nhánh con
        root.left = root.right;
        root.right = temp;

        // Gọi đệ quy để tiếp tục đảo các tầng sâu hơn bên dưới
        invertTree(root.left);
        invertTree(root.right);

        // Trả về cây đã được đảo ngược hoàn chỉnh
        return root;
    }
}