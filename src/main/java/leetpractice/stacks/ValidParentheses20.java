package leetpractice.stacks;

import java.util.Stack;

public class ValidParentheses20 {
    //https://leetcode.com/problems/valid-parentheses/description/

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    //brute force solution
    public static boolean isValid1(String s) {
       StringBuilder sb = new StringBuilder(s);
       int i = 0;

        while( i < sb.length() - 1){

            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
            if((a == '(' && b == ')') ||
                    (a == '{' && b == '}') ||
                    (a == '[' && b == ']')){
                sb.delete(i, i + 2);
                if (i > 0){
                    i--; // Move back one position to check for new adjacent pairs
                }

            } else {
                i ++;
            }
        }
        return sb.length() == 0;
    }

    public static void main(String[] args) {
        String s = "(()[]{})";
        boolean result = isValid(s);
        System.out.println(result); // Output: true
    }

}
