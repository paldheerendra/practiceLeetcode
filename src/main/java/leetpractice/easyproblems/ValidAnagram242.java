package leetpractice.easyproblems;

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

    public static void main(String[] args) {;
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result); // Output: true
    }
}
