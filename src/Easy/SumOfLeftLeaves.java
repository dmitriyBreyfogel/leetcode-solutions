package Easy;

import Common.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sum(root, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        return sum(root.left, true) + sum(root.right, false);
    }
}
