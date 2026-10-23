package leetpractice.mediumproblems;

public class MaxConsecutiveOnesIII1004 {
    //https://leetcode.com/problems/max-consecutive-ones-iii/description/

    //sliding window solution - optimized
    //this solution is optimized because we don't need to keep track of the max_len, we can just return the length of the array minus the left pointer

    //left pointer will be at the position where the number of zeros is greater than k,
    // so the length of the array minus the left pointer will give us the length of the longest subarray with at most k zeros
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros_count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros_count++;
            }
            if (zeros_count > k) {
                if (nums[left] == 0) {
                    zeros_count--;
                }
                left++;
            }

        }
        return   nums.length - left;
    }

    //sliding window solution
    public static int longestOnes1(int[] nums, int k) {
        int left = 0;
        int max_len = 0;
        int zeros_count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros_count++;
            }
            while (zeros_count > k) {
                if (nums[left] == 0) {
                    zeros_count--;
                }
                left++;
            }
            max_len = Math.max(max_len, right - left + 1);

        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1,1,1,0,0,0,1,1,1};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
}
