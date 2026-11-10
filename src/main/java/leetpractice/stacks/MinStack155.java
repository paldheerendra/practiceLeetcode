package leetpractice.stacks;

import java.util.Stack;

public class MinStack155 {
    //https://leetcode.com/problems/min-stack/description/

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() ||  minStack.peek() >= value) {
            minStack.push(value);
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int poppedValue = stack.peek();
        stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == poppedValue) {
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
