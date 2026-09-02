package Easy;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        path(root, "", result);
        return result;
    }

    private void path(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path +  root.val);
            return;
        }

        if (root.left != null) {
            path(root.left, path + root.val + "->", result);
        }

        if (root.right != null) {
            path(root.right, path + root.val + "->", result);
        }
    }
}
