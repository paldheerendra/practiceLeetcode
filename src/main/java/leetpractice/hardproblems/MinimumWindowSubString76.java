package leetpractice.hardproblems;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {
    //https://leetcode.com/problems/minimum-window-substring/description/

    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minStart = 0, count = t.length();
        while (right < s.length()) {
            // Expand the window
            if (charCount.containsKey(s.charAt(right))) {
                charCount.put(s.charAt(right), charCount.get(s.charAt(right)) - 1);
                if (charCount.get(s.charAt(right)) >= 0) {
                    count--;
                }
            }
            right++;

            // Shrink the window
            while (count == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }
                if (charCount.containsKey(s.charAt(left))) {
                    charCount.put(s.charAt(left), charCount.get(s.charAt(left)) + 1);
                    if (charCount.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result); // Output: "BANC"
    }
}
