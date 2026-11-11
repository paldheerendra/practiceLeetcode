package leetpractice.binarysearch;

public class RotatedArray33 {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    //binary search approach
    public static int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {
                // Target is in the left half
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // Right half is sorted
                // Target is in the right half
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }

// Another binary search approach using pivot
    public static int search(int[] nums, int target){
        int pivot = findPivot(nums);
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    public static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            //4 cases
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] < nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end; // Pivot index
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2 ;

            if(target < arr[mid] ) {
                end = mid - 1;

            }else if(target > arr[mid]) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr,target));
        System.out.println(findPivot(arr));
    }
}
