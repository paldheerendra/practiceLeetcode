package binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {-12, -4, 0, 2, 3, 4, 5, 9, 15, 16, 18, 22, 45, 89};
        int target = 9;
        
        System.out.println(binarySearch(arr, target));
	}
	
	// return the index
    // return -1 if it does not exist
	public static int binarySearch(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length - 1;
		
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
	

}
