package questions.evrydaystep;


import java.util.Stack;

public class Leecode239 {
    /** Initialize your data structure here. */
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public Leecode239() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }else {
            intoout();
            return outStack.pop();
        }

    }

    private void intoout() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }else {
            intoout();
            return outStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();

    }
}
