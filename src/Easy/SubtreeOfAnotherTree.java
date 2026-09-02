package Easy;

import Common.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;

        if (root.val == subRoot.val && isSameTrees(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTrees(TreeNode first, TreeNode second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.val != second.val) return false;

        return isSameTrees(first.left, second.left) && isSameTrees(first.right, second.right);
    }
}
