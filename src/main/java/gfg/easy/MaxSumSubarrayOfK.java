package gfg.easy;

public class MaxSumSubarrayOfK {
    //https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

    //sliding window solution
    static int maxSubarraySum(int[] arr, int k) {
        int window_sum = 0;
        for(int i = 0; i < k; i++){
            window_sum += arr[i];
        }
        int max_sum = window_sum; // Initialize max_sum with the sum of the first window
        for(int j = k; j < arr.length ; j++){
            window_sum += arr[j];
            window_sum -= arr[j - k];
            max_sum = Math.max(max_sum, window_sum);
        }
        return max_sum;
    }
    //brute force solution
    static int maxSubarraySum1(int[] arr, int k) {
        // code here
        int max_sum = 0;
        int n = arr.length;
        for(int i =0 ; i < n ; i++){
            int sum = 0;
            for(int j = i; j < i + k && i + k <= n; j++){
                sum += arr[j];
            }
            max_sum = Math.max(max_sum, sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        int k = 2;
        System.out.println(maxSubarraySum(arr, k));
    }


}
