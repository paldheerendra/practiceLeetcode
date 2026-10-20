package leetpractice.easyproblems;

public class RemoveAdjacentDuplicatesString1047 {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    //2 pointers approach

    // Time complexity: O(n), where n is the length of the input string s.
    // We iterate through the string once, and each character is processed at most twice
    // (once when added to the result string and once when removed).
    // Space complexity: O(n), where n is the length of the input string s.
    private static String removeDuplicates(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            int n = result.length();
            if ( n > 0 && result.charAt(n - 1) == c) {
                result = result.substring(0, n - 1);
            } else {
                result += c;
            }
        }
        return result;
    }

    // Time complexity: O(n), where n is the length of the input string s.
    // We iterate through the string once, and each character is processed at most twice
    // (once when added to the StringBuilder and once when removed).

    // Space complexity: O(n), where n is the length of the input string s.
    private static String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int length = sb.length();
            if (length > 0 && sb.charAt(length - 1) == c) {
                sb.deleteCharAt(length - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Time complexity: O(n^2), where n is the length of the input string s.
    // In the worst case, we may need to iterate through the string multiple times if there are many adjacent duplicates.
    // Each iteration takes O(n) time, and we may need to perform this process up to n times in the worst case.
    private static String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder();
        boolean reduced = false;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() -1 && s.charAt(i) == s.charAt(i + 1)){
                i++;
                reduced = true;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (reduced) {
            return removeDuplicates1(sb.toString());
        }
        return sb.toString();
    }
}
