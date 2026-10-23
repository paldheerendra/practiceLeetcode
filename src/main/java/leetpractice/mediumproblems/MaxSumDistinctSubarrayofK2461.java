package leetpractice.mediumproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSumDistinctSubarrayofK2461 {
    //https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

    //sliding window solution
    public static long maximumSubarraySum(int[] nums, int k) {
        long max_sum = 0;
        long window_sum = 0;
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        while(right < nums.length){
            if(!set.contains(nums[right])){
                set.add(nums[right]);
                window_sum += nums[right];
                if(right - left + 1 == k){
                    max_sum = Math.max(max_sum, window_sum);
                    window_sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                right++;
            }else{
                while(set.contains(nums[right])){
                    window_sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            }
        }
        return max_sum;
    }
    //brute force solution
    public static long maximumSubarraySum1(int[] nums, int k) {
        long max_sum = 0;
        for(int i = 0; i < nums.length - k + 1; i++){
            long window_sum = 0;
            boolean isDistinct = true;
            for(int j = i; j < i + k; j++){
                window_sum += nums[j];
                for(int l = j + 1; l < i + k; l++){
                    if(nums[j] == nums[l]){
                        isDistinct = false;
                        break;
                    }
                }
                if(!isDistinct){
                    break;
                }
            }
            if(isDistinct){
                max_sum = Math.max(max_sum, window_sum);
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9,1,2,3};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }
}
