package Easy;

import Common.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return result;

        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child);
            }
        }

        result.add(root.val);

        return result;
    }
}
