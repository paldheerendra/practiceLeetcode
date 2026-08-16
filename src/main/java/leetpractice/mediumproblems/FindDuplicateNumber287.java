package leetpractice.mediumproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateNumber287 {
    //https://leetcode.com/problems/find-the-duplicate-number/description/

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate2(nums));
    }

    private static int findDuplicate(int[] nums) { //leetcode submission time limit exceeded
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    duplicate = nums[i];
                }
            }
        }
        return duplicate;
    }

    private static int findDuplicate1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if(countMap.containsKey(num)) {
                return num;
            } else {
                countMap.put(num, 1);
            }
        }
        return -1;
    }

    //it fails if the duplicate number is greater than the length of the array, but in this problem,
    // it is guaranteed that the duplicate number is in the range [1, n], where n is the length of the array minus 1.
    private static int findDuplicate2(int[] nums) {
            int slow = nums[0];
            int fast = nums[0];

            // Move slow pointer by 1 step and fast pointer by 2 steps
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            // Find the entrance to the cycle
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
    }
}
