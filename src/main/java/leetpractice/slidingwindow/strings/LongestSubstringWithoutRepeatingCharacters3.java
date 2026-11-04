/**
 * 
 */
package leetpractice.slidingwindow.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dheerendra
 * 
 *         Longest Substring Without Repeating Characters
 *
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

	//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

	public static void main(String[] args) {
		int length = lengthOfLongestSubstring("abcabcbb");
		System.out.println(length);
	}
	//sliding window solution - O(n) time complexity
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;

		for(int right =0 ; right < s.length(); right++){
			char c = s.charAt(right);
			if(map.containsKey(c)){
				left = Math.max(left, map.get(c) + 1); // Update the left pointer to the next position after the last occurrence of the current character
			}
			map.put(c, right);
			max = Math.max(max, right -left + 1);
		}
		return max;
	}

	//sliding window solution - O(2n) time complexity
	public static int lengthOfLongestSubstring3(String s) {
		int max = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int right = 0 ; right < s.length() ; right++){
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);

			while(map.get(c) > 1){
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	//optimized solution - O(n) time complexity
	public static int lengthOfLongestSubstring2(String s) {
		int maxLength = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (sb.indexOf(String.valueOf(c)) != -1) {
				sb.delete(0, sb.indexOf(String.valueOf(c)) + 1);
			}
			sb.append(c);
			maxLength = Math.max(maxLength, sb.length());
		}
		return maxLength;
	}

	//brute force solution - O(n^2) time complexity
	public static int lengthOfLongestSubstring1(String s) {

			int index = 0, maxLen = 0;
			for (int i = 0; i < s.length(); i++) {

				Set<Character> set = new HashSet<>();

				for (int j = i; j < s.length(); j++) {
					char c = s.charAt(j);
					if (set.contains(c)) {
						break;
					}
					set.add(c);
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
			return maxLen;

	}

}
