package Easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                switch (c) {
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}
