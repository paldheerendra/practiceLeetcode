package leetpractice.easyproblems;

public class MaxAverageSubarray643 {
    //https://leetcode.com/problems/maximum-average-subarray-i/description/

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] arr, int k) {
        double window_sum = 0;
        for(int i = 0; i < k; i++){
            window_sum += arr[i];
        }
        double max_sum = window_sum / k; // Initialize max_sum with the sum of the first window
        for(int j = k; j < arr.length ; j++){
            window_sum += arr[j];
            window_sum -= arr[j - k];
            max_sum = Math.max(max_sum, window_sum/k);
        }
        return max_sum;
    }
}
