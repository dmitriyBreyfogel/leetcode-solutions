package Medium;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> result = new ArrayList<>();

        if (left > right) {
            result.add(null);
            return result;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generate(left, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, right);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
