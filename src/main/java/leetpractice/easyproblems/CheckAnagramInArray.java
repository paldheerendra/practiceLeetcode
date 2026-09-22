package leetpractice.easyproblems;

import java.util.Arrays;

public class CheckAnagramInArray {

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

    public static void main(String[] args) {;
        String arr[] = {"anagram", "nagaram", "rat", "hello", "art"};
        String str = "tar";

        String[] result = checkAnagramInArray(arr, str);
        System.out.println(Arrays.toString(result)); // Output: true
    }

}
