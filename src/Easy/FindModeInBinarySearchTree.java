package Easy;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        traversingTree(root, map);

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void traversingTree(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        if (root.left != null) {
            traversingTree(root.left, map);
        }

        if (root.right != null) {
            traversingTree(root.right, map);
        }
    }
}
