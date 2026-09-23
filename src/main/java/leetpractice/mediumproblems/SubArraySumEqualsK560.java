package leetpractice.mediumproblems;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK560 {
    //https://leetcode.com/problems/subarray-sum-equals-k/description/

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize the map with prefix sum 0 having frequency 1 (to handle cases where a subarray itself sums to k)
        for (int num : nums) {
            prefix += num;
            count += map.getOrDefault(prefix - k, 0); // Get the number of subarrays that sum up to (prefix - k)
            map.put(prefix, map.getOrDefault(prefix, 0) + 1); // Update the frequency of the current prefix sum
        }
        return count;
    }
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println(result); // Output: 2
    }
}
