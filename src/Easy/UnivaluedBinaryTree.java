package Easy;

import Common.TreeNode;

public class UnivaluedBinaryTree {
    private static int first;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;

        first = root.val;

        return bfs(root);
    }

    private boolean bfs(TreeNode root) {
        if (root == null) return true;
        if (root.val != first) return false;

        return bfs(root.left) && bfs(root.right);
    }
}
