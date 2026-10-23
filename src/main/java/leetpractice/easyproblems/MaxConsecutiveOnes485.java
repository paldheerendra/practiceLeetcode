package leetpractice.easyproblems;

public class MaxConsecutiveOnes485 {
    //https://leetcode.com/problems/max-consecutive-ones/description/

    //sliding window solution
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max_len = 0;
        int current_count =0;

        for(int j = 0 ; j < nums.length ; j++) {
            if (nums[j] == 1) {
                current_count++;
            } else {
                max_len = Math.max(max_len, current_count);
                current_count = 0;
            }

        }
        return Math.max(max_len, current_count);
    }


    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
