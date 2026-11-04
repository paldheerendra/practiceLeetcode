package leetpractice.slidingwindow.strings;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {
    //https://leetcode.com/problems/permutation-in-string/description/


    //sliding window solution - O(n + m) time complexity, space complexity - O(1)
    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
                return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, count = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);

            int val = map.getOrDefault(c, 0);
            if (val > 0) count--;

            map.put(c, val - 1);

            if (count == 0)
                return true;

            if (right - left + 1 == s1.length()) {
                char leftChar = s2.charAt(left);

                int leftVal = map.get(leftChar);
                if (leftVal >= 0) count++;
                map.put(leftChar, leftVal + 1);
                left++;
            }
        }
        return false;
    }

    //brute force solution - O(n * m) time complexity, space complexity - O(1)
    public static boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                s2Count[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (matches(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
