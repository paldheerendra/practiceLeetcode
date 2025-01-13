package sortingalgo;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 20, 0, 1, 2, 4, 5, 3, -23 };

		selectionSort(arr);

		System.out.println(Arrays.toString(arr));

	}
	
	public static void selectionSort(int[] arr) {
		
		for(int i = 0; i < arr.length ; i++) {
			
			//find the max item and swap with correct index
			int last = arr.length - i - 1;
			int maxIndex = getMaxIndex(arr, 0, last);
			swap(arr, maxIndex, last);
		}
		
		
	}

	private static int getMaxIndex(int[] arr, int start, int end) {
		
		int max = start;
		for(int i = start; i <= end ; i++) {
			
			if(arr[max] < arr[i] ) {
				max = i;
			}
		}
		
		return max;
	}

	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;

	}

}
