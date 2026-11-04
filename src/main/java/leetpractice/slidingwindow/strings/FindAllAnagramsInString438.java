package leetpractice.slidingwindow.strings;

import java.util.*;

public class FindAllAnagramsInString438 {

    //https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

    //sliding window solution, 2 map solution - O(n) time complexity
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, count = p.length();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if(pMap.containsKey(c) && sMap.get(c) <= pMap.get(c)) {
                count--;
            }

            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                if(pMap.containsKey(leftChar) && sMap.get(leftChar) <= pMap.get(leftChar)) {
                    count++;
                }
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                left++;
            }
            if (count == 0) {
                result.add(left);
            }
        }
        return result;
    }

    //brute force solution - O(n * m) time complexity
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]
    }
}
