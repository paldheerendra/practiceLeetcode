package leetpractice.easyproblems;

public class LongestPalindrome409 {

    //https://leetcode.com/problems/longest-palindrome/description/

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int length = 0;
        for (int i : count) {
            length += (i / 2) * 2;
        }
        if (length < s.length()) {
            length++;
        }
        return length;
    }
}
