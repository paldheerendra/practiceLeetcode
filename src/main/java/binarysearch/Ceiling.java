package binarysearch;

public class Ceiling {
	
	//https://leetcode.com/problems/search-insert-position/
	public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 7;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

    // return the index of smallest no >= target
    static int ceiling(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        //int index = 0;
        while(start <= end) {
            // find the middle element
        	// int mid = (start + end) / 2; 
        	// might be possible that (start + end) exceeds the range of int in java
            
        	int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
                //index = mid ;
            } else if (target > arr[mid]) {
                start = mid + 1;
                //index = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return start; //index
    }

}
