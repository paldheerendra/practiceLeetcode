/**
 * 
 */
package leetpractice.mediumproblems;

import java.util.HashSet;
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
		int length = lengthOfLongestSubstring2("abcabcbb");
		System.out.println(length);
	}
	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		int max = 0;
		Set<Character> hs = new HashSet<>();
		int left = 0;

		for(int right =0 ; right < n; right++){
			if(!hs.contains(s.charAt(right))){
				hs.add(s.charAt(right));
				max = Math.max(max, right -left + 1);
			}else{
				while(hs.contains(s.charAt(right))){
					hs.remove(s.charAt(left));
					left++;
				}
				hs.add(s.charAt(right));
			}
		}
		return max;
	}

	public static int lengthOfLongestSubstring1(String s) {
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

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() > 1) {
			int index = 0, finalIndex = 0;
			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j < s.length(); j++) {
					if(s.length() ==2 && s.charAt(i) != s.charAt(j)) {
						finalIndex = s.length();
						break;
					}
					else if (s.charAt(i) == s.charAt(j)) {
						index = j - i;
						if (index > finalIndex) {
							finalIndex = index;
						}
						i = j-1;
						break;
					}
				}
			}
			return finalIndex;
		} else
			return s.length();
	}

}
