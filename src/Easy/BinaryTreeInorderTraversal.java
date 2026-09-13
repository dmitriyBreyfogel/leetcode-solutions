package Easy;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        if (root.left != null) traverse(root.left);
        if (root.right != null) traverse(root.right);
        result.add(root.val);
    }
}
