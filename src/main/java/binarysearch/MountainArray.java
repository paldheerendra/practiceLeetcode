package binarysearch;

public class MountainArray {
	 // https://leetcode.com/problems/find-peak-element/
	//https://leetcode.com/problems/peak-index-in-a-mountain-array/
	
	public static void main(String [] args) {
		int[] nums = {1,2,1,3,5,6,4};
		int index = PeakIndexInMountainArray(nums);
		System.out.println(index);
		
		int[] arr = {0,10,5,2};
		System.out.println(PeakIndexInMountainArray(arr));

	}
	static int PeakIndexInMountainArray(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			int mid = start + (end - start) / 2;
			if(arr[mid] > arr[mid + 1]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
		
	}
	

}
