package Easy;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stackS.isEmpty() && ch == '#') continue;
            if (!stackS.isEmpty() && ch == '#') stackS.pop();
            else stackS.push(ch);
        }

        Stack<Character> stackT = new Stack<>();
        for (char ch : t.toCharArray()) {
            if (stackT.isEmpty() && ch == '#') continue;
            if (!stackT.isEmpty() && ch == '#') stackT.pop();
            else stackT.push(ch);
        }

        return stackS.equals(stackT);
    }
}
