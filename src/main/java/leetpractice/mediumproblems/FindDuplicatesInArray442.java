package leetpractice.mediumproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInArray442 {

    //https://leetcode.com/problems/find-all-duplicates-in-an-array/description

    public static void main(String[] args) {

            int[] nums = {4,3,2,7,8,2,3,1};
            System.out.println(findDuplicatesBrutForce(nums));
    }

    private static List<Integer> findDuplicatesBrutForce(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && !duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                }
            }
        }
        return duplicates;
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    private static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if(countMap.containsKey(num)) {
                duplicates.add(num);
            } else {
                countMap.put(num, 1);
            }

        }
        return duplicates;
    }

    private static List<Integer> findDuplicateswithBigOofNandConstantSpace(int[] nums) {

            List<Integer> duplicates = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1; // Get the index corresponding to the value at nums[i]
                if (nums[index] < 0) {
                    // If the value at that index is already negative, it means we've seen this number before
                    duplicates.add(Math.abs(nums[i])); // Add the duplicate number to the result list
                }
                // Mark the value at that index as negative to indicate that we've seen this number
                nums[index] = -nums[index];
            }
            return duplicates;


    }

}
