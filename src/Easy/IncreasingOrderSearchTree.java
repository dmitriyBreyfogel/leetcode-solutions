package Easy;

import Common.TreeNode;

public class IncreasingOrderSearchTree {
    TreeNode result;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        result = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        root.left = null;
        result.right = root;
        result = result.right;

        inorder(root.right);
    }
}
