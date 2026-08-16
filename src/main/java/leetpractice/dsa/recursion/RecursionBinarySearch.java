package leetpractice.dsa.recursion;

public class RecursionBinarySearch {

    //https://leetcode.com/problems/binary-search/

    public static void main(String[] args) {
        int[] nums = {1,3,5,6,7,9};
        System.out.println(searchBinary(nums , 0 , nums.length-1, 7));
    }

    public static int search(int[] nums, int target) {
       return -1;

    }

    public static int searchBinary(int[] nums, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else
                return mid;
        }
        return -1;
    }

}
