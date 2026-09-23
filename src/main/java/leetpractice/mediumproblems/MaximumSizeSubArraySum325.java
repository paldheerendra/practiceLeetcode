package leetpractice.mediumproblems;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySum325 {
    //https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/


    public static int maxSubArrayLen(int[] nums, int k) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize the map with prefix sum 0 having index -1 (to handle cases where a subarray itself sums to k)
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            // Only add the current sum to the map if it is not already present
            // This ensures we keep the earliest index for each prefix sum
            map.putIfAbsent(sum, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int result = maxSubArrayLen(nums, k);
        System.out.println(result); // Output: 4
    }
}
