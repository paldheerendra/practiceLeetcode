package leetpractice.hardproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromPairs336 {

    //https://leetcode.com/problems/palindrome-pairs/description/
    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs1(words));
    }

    private static List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i != j && isPalindrome(words[i] + words[j])) {
                    result.add(List.of(i, j));
                }
            }

        }
        return result;
    }

    private static List<List<Integer>> palindromePairs1(String[] words) {

        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                if(isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reversedRight) && map.get(reversedRight) != i) {
                        result.add(List.of(map.get(reversedRight), i));
                    }
                }

                if(isPalindrome(right) && right.length() != 0) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reversedLeft) && map.get(reversedLeft) != i) {
                        result.add(List.of(i, map.get(reversedLeft)));
                    }
                }
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s) {
       StringBuilder sb = new StringBuilder(s);
       return s.equals(sb.reverse().toString());
    }

}
