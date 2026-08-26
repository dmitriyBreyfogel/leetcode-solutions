import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<Integer>();
    }

    public void push(int x) {
        q.add(x);

        int size = q.size();
        for(int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        if (q.peek() == null) {
            throw new NoSuchElementException();
        }

        return q.poll();
    }

    public int top() {
        if (q.peek() == null) {
            throw new NoSuchElementException();
        }

        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */