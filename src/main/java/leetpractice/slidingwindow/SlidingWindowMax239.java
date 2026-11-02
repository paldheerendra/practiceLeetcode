package leetpractice.slidingwindow;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowMax239 {
    //https://leetcode.com/problems/sliding-window-maximum/description/

    //sliding window solution - O(n) time complexity
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // Add the current element to the deque
            deque.addLast(right);

            // The maximum of the current window is at the front of the deque
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }


    //sliding window solution - TLE
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (right - left + 1 == k) {
                int pointer = left;
                int max = nums[pointer];
                while (pointer <= right) {
                    max = Math.max(max, nums[pointer]);
                    pointer++;
                }
                result[left] = max;
                left++;
            }
        }
        return result;
    }

    //sliding window solution - TLE
    public int[] maxSlidingWindow1(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        int left = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (right - left + 1 == k) {
                result[left] = map.keySet().stream().max(Integer::compareTo).get();
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
