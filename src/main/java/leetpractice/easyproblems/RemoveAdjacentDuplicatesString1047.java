package leetpractice.easyproblems;

public class RemoveAdjacentDuplicatesString1047 {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    private static String removeDuplicates(String s) {
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
