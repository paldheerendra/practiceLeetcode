package leetpractice.hardproblems;

import java.util.*;

public class WordBreakII140 {
    //https://leetcode.com/problems/word-break-ii/description/

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = wordBreak(s, wordDict);
        System.out.println(result);
    }
    // Approach: Recursive Backtracking
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (wordDict.contains(prefix)) {
                String suffix = s.substring(i + 1);
                if (suffix.isEmpty()) {
                    result.add(prefix);
                } else {
                    List<String> suffixBreaks = wordBreak(suffix, wordDict);
                    for (String suffixBreak : suffixBreaks) {
                        result.add(prefix + " " + suffixBreak);
                    }
                }
            }
        }
        return result;
    }

// Approach: Backtracking with memoization
    public static List<String> wordBreak1(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, 0, wordSet, memo);
    }

    private static List<String> backtrack(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> sentences = new ArrayList<>();
        if (start == s.length()) {
            sentences.add("");
            return sentences;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> subSentences = backtrack(s, end, wordSet, memo);
                for (String subSentence : subSentences) {
                    String sentence = word + (subSentence.isEmpty() ? "" : " ") + subSentence;
                    sentences.add(sentence);
                }
            }
        }

        memo.put(start, sentences);
        return sentences;
    }
}
