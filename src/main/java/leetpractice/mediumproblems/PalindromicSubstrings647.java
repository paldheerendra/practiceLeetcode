package leetpractice.mediumproblems;

public class PalindromicSubstrings647 {

    //https://leetcode.com/problems/palindromic-substrings/description/
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes
            count += expandAroundCenter(s, i, i);
            // Even length palindromes
            count += expandAroundCenter(s, i, i + 1);
        }
        return count;
    }
    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }


    //Brute force approach: Generate all possible substrings and check if they are palindromes.
    // This has a time complexity of O(n^3) because generating all substrings takes O(n^2)
    // and checking if each substring is a palindrome takes O(n).
    public static int countSubstrings1(String s) {
        int count = 0;
        for(int i= 0 ; i < s.length(); i++){
            for(int j=i ; j < s.length(); j ++){
                String sub = s.substring(i, j + 1); // j + 1 because substring is exclusive of the end index
                if(isPalindrome(sub)){
                    count++;
                }
            }
        }
        return count;
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
        String s = "aaa";
        int result = countSubstrings(s);
        System.out.println(result); // Output: 6
    }
}
