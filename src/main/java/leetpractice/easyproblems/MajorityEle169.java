package leetpractice.easyproblems;

import java.util.HashMap;
import java.util.Map;

public class MajorityEle169 {
    //https://leetcode.com/problems/majority-element/description/


    // using hashmap
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > majorityCount) {
                return num;
            }
        }
        return -1; // This line will never be reached since the problem guarantees a majority element exists.
    }


    //Boyer-Moore Voting Algorithm
    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }
}
