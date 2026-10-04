package Easy;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode parentX = null;
            TreeNode parentY = null;

            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    if (node.left.val == x) {
                        foundX = true;
                        parentX = node;
                    }
                    if (node.left.val == y) {
                        foundY = true;
                        parentY = node;
                    }
                    queue.add(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x) {
                        foundX = true;
                        parentX = node;
                    }
                    if (node.right.val == y) {
                        foundY = true;
                        parentY = node;
                    }
                    queue.add(node.right);
                }
            }

            if (foundX && foundY) {
                return parentX != parentY;
            }

            if (foundX || foundY) {
                return false;
            }
        }

        return false;
    }
}
