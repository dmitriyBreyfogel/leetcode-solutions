package Easy;

import Common.TreeNode;

public class BinaryTreeTilt {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        subtreeSum(root);
        return totalTilt;
    }

    private int subtreeSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = subtreeSum(node.left);
        int rightSum = subtreeSum(node.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }
}
