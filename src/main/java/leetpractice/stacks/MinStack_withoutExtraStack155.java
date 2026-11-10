package leetpractice.stacks;

import java.util.Stack;

public class MinStack_withoutExtraStack155 {
    //https://leetcode.com/problems/min-stack/description/

    Stack<Integer> stack;
    int min;

    public MinStack_withoutExtraStack155() {
        stack = new Stack<>();
    }

    public void push(int value) {

        if (stack.size() == 0) {
            stack.push(value);
            min = value;
        } else {
            if(value >= min) {
                stack.push(value);
            } else if(value < min) {
                stack.push(2 * value - min);
                min = value;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        } else {
            int top = stack.pop();
            if(top >= min) {
                stack.pop();
            } else if(top < min) {
                min = 2 * min - top;
                stack.pop();
            }
        }
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }else {
            int top = stack.peek();
            if(top >= min) {
                return top;
            } else if(top < min) {
                return min;
            }
        }
        return -1;
    }

    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return min;
    }
}
