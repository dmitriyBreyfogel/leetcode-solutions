package Easy;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum4InputBST {
    List<Integer> values = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorderTraversal(root);

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            int sum = values.get(left) + values.get(right);

            if (sum == k) return true;
            else if (sum < k) left++;
            else right--;
        }

        return false;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        values.add(root.val);
        inorderTraversal(root.right);
    }
}
