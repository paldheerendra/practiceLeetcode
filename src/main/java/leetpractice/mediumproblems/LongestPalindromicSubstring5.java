package leetpractice.mediumproblems;

public class LongestPalindromicSubstring5 {
    //https://leetcode.com/problems/longest-palindromic-substring/description/

    //2 pointer solution - optimized
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //brute force solution
    public static String longestPalindrome1(String s) {
        String longest = "";
        for(int i =0; i < s.length(); i++){
            for(int j = i; j <= s.length(); j++){
                String sub = s.substring(i, j);
                if(isPalindrome(sub)){
                    if( sub.length() > longest.length()){
                        longest = sub;
                    }
                }
            }
        }
        return longest;
    }

    static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result); // Output: "bab" or "aba"
    }

}
