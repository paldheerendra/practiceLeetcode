package leetpractice.stacks;

import java.util.Stack;

public class NextGreaterElementII503 {

    //https://leetcode.com/problems/next-greater-element-ii/description/

    //https://www.geeksforgeeks.org/next-greater-element-circular-array/

    //monotonic stack solution
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate twice over the array to handle circular nature
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            // Only fill the result array for the first pass
            if(i<n){
                if(stack.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = stack.peek();
                }
            }
            stack.push(nums[i % n]); // Push the current element onto the stack for future comparisons
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1}; //output: 2 -1 2
        int[] result = nextGreaterElements(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
