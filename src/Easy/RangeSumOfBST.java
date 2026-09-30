package Easy;

import Common.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        // Everything on the left is smaller, so skip it entirely
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Everything on the right is larger, so skip it entirely
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Node fits the range — include it and explore both sides
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
