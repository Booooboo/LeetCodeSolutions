import java.util.Stack;

/**
 * Created by sunhongbo on 16/5/10.
 */
public class ImplementQueneStack {

    Stack<Integer> mStacktmp = new Stack<Integer>();
    Stack<Integer> mStack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        if (mStack.isEmpty()) {
            mStack.push(x);
        } else {
            while (!mStack.isEmpty()) {
                mStacktmp.push(mStack.pop());
            }
            mStacktmp.push(x);
            while (!mStacktmp.isEmpty()) {
                mStack.push(mStacktmp.pop());
            }
        }
        //mStacktmp.push(x);
        //while (!mStacktmp.isEmpty()) {
        //    mStack.push(mStacktmp.pop());
        //}
    }

    // Removes the element from in front of queue.
    public void pop() {
        mStack.pop();
        //while (!mStack.isEmpty()) {
        //    mStacktmp.push(mStack.pop());
        //}
    }

    // Get the front element.
    public int peek() {
        return mStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mStack.isEmpty();
    }
}
