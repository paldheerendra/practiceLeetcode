package leetpractice.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum423 {
    //https://leetcode.com/problems/continuous-subarray-sum/description/

    //prefix sum approach with hashmap
    public static boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize the map with prefix sum 0 having index -1
        // (to handle cases where a subarray itself sums to k)
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = prefix % k; // Get the modulus of the current prefix sum with k
            // If this modulus has been seen before, it means there exists a subarray that sums to a multiple of k
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) { // Check if the length of the subarray is at least 2
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    //brute force solution - TLE
    public static boolean checkSubarraySum1(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum % k == 0 && j - i >= 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean result = checkSubarraySum(nums, k);
        System.out.println(result); // Output: true
    }
}
