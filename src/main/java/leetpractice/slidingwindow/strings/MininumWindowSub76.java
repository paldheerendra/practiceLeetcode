package leetpractice.slidingwindow.strings;

import java.util.HashMap;
import java.util.Map;

public class MininumWindowSub76 {
    //https://leetcode.com/problems/minimum-window-substring/description/

    //sliding window solution - O(n + m) time complexity, space complexity - O(1)
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minStart = 0, count = t.length();
        while (right < s.length()) {
            // Expand the window
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
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
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    //sliding window solution, 1 map - O(n + m) time complexity, space complexity - O(1)
    public static String minWindow2(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, minLen = Integer.MAX_VALUE, count = t.length();
        String ans = "";
        for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        count--;
                    }
                    map.put(c, map.get(c) - 1);
                }
                // Shrink the window
                while (count == 0) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        ans = s.substring(left, right + 1);
                    }

                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) > 0) {
                            count++;
                        }
                    }
                    left++;
                }
            }
        return ans;
    }

    //sliding window solution, 2 maps - O(n + m) time complexity
    public static String minWindow1(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> smap = new HashMap<>();

        int left = 0, minLen = Integer.MAX_VALUE, count = t.length();
        String ans = "";
        for (int right = 0; right < s.length(); right++) {
            {
                char c = s.charAt(right);
                smap.put(c, smap.getOrDefault(c, 0) + 1);
                if (tmap.containsKey(c) && smap.get(c) <= tmap.get(c)) {
                    count--;
                }

                // Shrink the window
                while (count == 0) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        ans = s.substring(left, right + 1);
                    }

                    char leftChar = s.charAt(left);
                    smap.put(leftChar, smap.get(leftChar) - 1);

                    if (tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar)) {
                        count++;
                    }
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
