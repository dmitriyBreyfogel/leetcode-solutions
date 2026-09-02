package Easy;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
        }

        return minDiff;
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }
}
