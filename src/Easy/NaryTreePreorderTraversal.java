package Easy;

import Common.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return result;

        result.add(root.val);

        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child);
            }
        }

        return result;
    }
}
