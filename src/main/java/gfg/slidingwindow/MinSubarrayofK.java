package gfg.slidingwindow;

public class MinSubarrayofK {

    //https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1

    public static int smallestSubWithSum(int x, int[] nums) {
        // code here
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0 ; right < nums.length; right++) {
            sum += nums[right];

            while (sum > x) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 45, 6, 0, 19};
        int x = 51;
        int result = smallestSubWithSum(x, nums);
        System.out.println(result); // Output: 3
    }
}
