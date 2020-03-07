package test;

import java.util.Stack;

/**
 * 155. Min Stack
 * Difficult: Easy
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class T155_MinStack {

    /**
     * 执行用时 :12 ms, 22.91%
     * 内存消耗 :40.4 MB, 37.61%
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    static class MinStack {

        Stack<Integer> data;
        Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (helper.isEmpty() || x <= helper.peek())
                helper.push(x);
        }

        public void pop() {
            if (!data.isEmpty()) {
                int top = data.pop();
                if (top == helper.peek())
                    helper.pop();
            }
        }

        public int top() {
            if (!data.isEmpty())
                return data.peek();
            throw new RuntimeException("stack is null!");
        }

        public int getMin() {
            if (!helper.isEmpty())
                return helper.peek();
            throw new RuntimeException("stack is null!");
        }
    }
}
