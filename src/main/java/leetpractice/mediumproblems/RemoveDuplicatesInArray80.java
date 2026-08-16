package leetpractice.mediumproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesInArray80 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

    public static void main(String[] args) {

            int[] nums = {1,1,1,2,2,3};
            //output: 7, nums = [0,0,1,1,2,3,3]
            System.out.println(removeDuplicates1(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int j = 1; // Pointer for the position to place the next valid element
        int count = 1; // Count of the current number

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1; // Reset count for a new number
            }

            if (count <= 2) {
                nums[j] = nums[i]; // Place the current number at the j-th position
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j; // New length of the array with duplicates removed
    }

    private static int removeDuplicates1(int[] nums){

            int n = nums.length;
            if (n <= 2) {
                return n;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 2) {
                    entry.setValue(2);
                }
            }

            return map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
