package leetpractice.mediumproblems;

import java.util.*;

public class GroupAnagram49 {
    //https://leetcode.com/problems/group-anagrams/description/

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Set<String> processed = new HashSet<>();

        for (String str : strs) {
            if (!processed.contains(str)) {
                String[] anagrams = checkAnagramInArray(strs, str);
                result.add(Arrays.asList(anagrams));
                processed.addAll(Arrays.asList(anagrams));
            }
        }
        return result;

    }

    private static String[] checkAnagramInArray(String[] arr, String str) {
        String[] anagrams = new String[arr.length];
        int index = 0;
        for (String s : arr) {
            if (isAnagram(s, str)) {
                anagrams[index++] = s;
            }
        }
        return Arrays.copyOf(anagrams, index);
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toLowerCase().toCharArray();
        char[] tChars = t.toLowerCase().toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strs));
    }
}
