import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunhongbo on 16/5/26.
 */
public class ImplementStackusingQueues {
    Queue<Integer> mQueue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<Integer>();
        temp.add(x);
        while (!mQueue.isEmpty()) {
            temp.add(mQueue.remove());
        }
        while (!temp.isEmpty()) {
            mQueue.add(temp.remove());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        mQueue.poll();
    }

    // Get the top element.
    public int top() {
        return mQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return mQueue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackusingQueues myStack = new ImplementStackusingQueues();
        myStack.push(1);
        myStack.push(2);
        myStack.push(4);
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
    }
}
