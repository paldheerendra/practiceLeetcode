package leetpractice.prefixsum;

public class FindPivotIndex724 {
    //https://leetcode.com/problems/find-pivot-index/description/

    //prefix sum approach
    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            //Calculate right sum by subtracting left sum and current element from total sum
           int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    //brute force solution
    public static int pivotIndex1(int[] nums) {
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int rightSum = 0;
            for(int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6}; // Expected output: 3
        System.out.println(pivotIndex(arr));
    }
}
