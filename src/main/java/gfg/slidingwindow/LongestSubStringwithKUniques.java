package gfg.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringwithKUniques {
    //https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

    private static int longestKUnique(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = -1;
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            //shrink the window from the left until we have at most k unique characters
            while (map.size() > k) {
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        System.out.println(longestKUnique(str, k)); // Output: 7

        String str2 = "aaaa";
        int k2 = 1;
        System.out.println(longestKUnique(str2, k2)); // Output: 4

        String str3 = "abcabc";
        int k3 = 2;
        System.out.println(longestKUnique(str3, k3)); // Output: 2
    }

}
