package leetpractice.heap;

import java.util.PriorityQueue;

public class KthSmallestEle {

    //heap approach - add all elements to min heap and pop k-1 elements from the heap and return the top element
    public static int findKthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    //brute force approach - sort the array and return the kth element
    public static int findKthSmallest1(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr[k - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4}; //output: 2
        int k = 2;
        System.out.println(findKthSmallest(arr, k));
    }


}
