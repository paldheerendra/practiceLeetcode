package leetpractice.mediumproblems;

public class RemoveAdjacentDuplicatesString1209 {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        //output: "ps"
        System.out.println(removeDuplicates2(s, 3));
    }

    private static String removeDuplicates(String s , int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int length = sb.length();
            if (length >= k - 1 && sb.substring(length - k + 1, length).chars().allMatch(ch -> ch == c)) {
                sb.delete(length - k + 1, length);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //failing at leetcode submissions
    private static String removeDuplicates1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        boolean reduced = false;
        for (int i = 0; i < s.length(); i++) {
            if (i <= s.length() - k && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + k - 1)){
                i = i + k - 1;
                reduced = true;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (reduced) {
            return removeDuplicates1(sb.toString(), k);
        }
        return sb.toString();
    }

    private static String removeDuplicates2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[s.length()];
        for (char c : s.toCharArray()) {
            sb.append(c);
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == sb.charAt(length - 2)) {
                count[length - 1] = count[length - 2] + 1;
            } else {
                count[length - 1] = 1;
            }
            if (count[length - 1] == k) {
                sb.delete(length - k, length);
            }
        }
        return sb.toString();
    }
}
