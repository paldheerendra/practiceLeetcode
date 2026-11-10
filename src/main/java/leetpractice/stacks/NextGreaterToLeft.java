package leetpractice.stacks;

import java.util.Stack;

public class NextGreaterToLeft {


    public static int[] nextGreaterToLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8}; //output: -1 -1 5 -1 10
        int[] result = nextGreaterToLeft(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
