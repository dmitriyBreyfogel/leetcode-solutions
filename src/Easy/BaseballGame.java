package Easy;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String op : operations) {
            switch (op) {
                case "+":
                    int a = stack.isEmpty() ? 0 : stack.pop();
                    int b = stack.isEmpty() ? 0 : stack.pop();
                    int sum = a + b;
                    stack.push(b);
                    stack.push(a);
                    stack.push(sum);
                    break;
                case "D":
                    int top = stack.isEmpty() ? 0 : stack.peek();
                    stack.push(top * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        for(Integer i : stack) {
            sum += i;
        }

        return sum;
    }
}
