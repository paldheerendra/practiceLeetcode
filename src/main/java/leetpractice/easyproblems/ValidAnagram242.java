package leetpractice.easyproblems;

import java.util.Arrays;
import java.util.Locale;

public class ValidAnagram242 {
    //https://leetcode.com/problems/valid-anagram/description/

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            int index = t.indexOf(c);
            if (index == -1) {
                return false;
            }
            t = t.substring(0, index) + t.substring(index + 1);
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toLowerCase().toCharArray();
        char[] tChars = t.toLowerCase().toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {;
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram1(s, t);
        System.out.println(result); // Output: true
    }
}
