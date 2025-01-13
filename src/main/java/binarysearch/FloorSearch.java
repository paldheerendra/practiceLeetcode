package binarysearch;

//https://www.geeksforgeeks.org/floor-in-a-sorted-array/
public class FloorSearch {

	// floor of a number
	// find number which is greatest number <=target --> floor
	public static void main(String[] args) {
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int target = 0;

		int floorIndex = floorIndex(arr, target);
		System.out.println(floorIndex); // index

		int floorNumber = floor(arr, target);
		System.out.println("Floor number : " + floorNumber);

	}

	private static int floor(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		if (target < arr[0]) {
			return -1;
		} else {
			while (start <= end) {
				int mid = start + (end - start) / 2;

				if (target < arr[mid]) {
					end = mid - 1;
				} else if (target > arr[mid]) {
					start = mid + 1;
				} else {
					return arr[mid];
				}
			}
		}
		return arr[end];
	}

	public static int floorIndex(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return end;
	}

}
