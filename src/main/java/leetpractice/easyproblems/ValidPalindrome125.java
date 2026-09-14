package leetpractice.easyproblems;

import java.util.Locale;

public class ValidPalindrome125 {

    //https://leetcode.com/problems/valid-palindrome/description/
    public static void main(String[] args) {
        System.out.println(isPalindrome1("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String s) {
        //String str = s.toLowerCase();
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome1(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }


}
