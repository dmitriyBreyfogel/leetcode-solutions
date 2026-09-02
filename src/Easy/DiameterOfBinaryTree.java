package Easy;

import Common.TreeNode;

public class DiameterOfBinaryTree {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;
    }
}
