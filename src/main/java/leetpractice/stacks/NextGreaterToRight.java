package leetpractice.stacks;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NextGreaterToRight {


    private static int[] nextGreaterToRight(int[] arr) {
        //Vector<Integer> result = new Vector<>();
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--) {
            /*if(stack.empty()) {
                result[i] = -1;
            }else if (!stack.empty() && stack.peek() > arr[i]) {
                result[i] = stack.peek();
            }else if (!stack.empty() && stack.peek() <= arr[i]) {*/
                while(!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if(stack.empty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            //}
            stack.push(arr[i]);
        }
        // Reverse the result vector to get the correct order


        /*int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(result.size() - 1 - i);
        }*/
        return result;
    }
    //brute force solution - TLE
    private static int[] nextGreaterToRight1(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int nextGreater = -1;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    nextGreater = arr[j];
                    break;
                }
            }
            arr[i] = nextGreater;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25}; //output: 5 25 25 -1
        int[] result = nextGreaterToRight1(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
