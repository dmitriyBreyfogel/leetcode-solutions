package Easy;

import Common.TreeNode;

public class SecondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        long res = dfs(root, root.val);
        return res == Long.MAX_VALUE ? -1 : (int) res;
    }

    private long dfs(TreeNode root, int min) {
        if (root == null) return Long.MAX_VALUE;

        if (root.val > min) return root.val;

        return Math.min(dfs(root.left, min), dfs(root.right, min));
    }
}
