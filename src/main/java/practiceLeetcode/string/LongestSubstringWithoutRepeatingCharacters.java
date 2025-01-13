/**
 * 
 */
package practiceLeetcode.string;

/**
 * @author Dheerendra
 * 
 *         Longest Substring Without Repeating Characters
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		int length = lengthOfLongestSubstring("aaaaaaa");
		System.out.println(length);
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

					/*
					 * else continue;
					 */

				}
				// break;
			}
			return finalIndex;
		} else
			return s.length();
	}

}
