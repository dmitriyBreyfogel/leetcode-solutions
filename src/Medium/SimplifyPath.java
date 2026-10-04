package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }

            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(token);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }

        return result.isEmpty() ? "/" : result.toString();
    }
}
