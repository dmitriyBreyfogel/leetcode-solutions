package Medium;

import Common.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode prev;
    TreeNode wrong1;
    TreeNode wrong2;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int tmp = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            if (wrong1 == null) {
                wrong1 = prev;
            }

            wrong2 = root;
        }

        prev = root;

        inorder(root.right);
    }
}
