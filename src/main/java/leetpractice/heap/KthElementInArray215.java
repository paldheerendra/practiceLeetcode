package leetpractice.heap;

import java.util.PriorityQueue;

public class KthElementInArray215 {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/description/

    //heap solution - time complexity = O(nlogk)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    //bubble sort solution - TLE, time complexity = O(n^2)
    public static int findKthLargest1(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    // Swap nums[j] and nums[j + 1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[k - 1];
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4}; //o/p = 5
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }
}
