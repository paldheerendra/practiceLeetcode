package leetpractice.mediumproblems;

public class SubarrayProdLessThanK713 {

    //https://leetcode.com/problems/subarray-product-less-than-k/description/

    //sliding window solution
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0, left = 0, prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    //brute force solution
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {

        if(k <= 1) return 0;

        int count = 0;

        for(int i =0 ; i < nums.length ; i++){
            int prod = 1;
            for(int j = i ; j >=0 ; j--){
                prod *=nums[j];
                if(prod < k){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

}
