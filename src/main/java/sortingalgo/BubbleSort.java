package sortingalgo;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {20,0,1, 2, 4, 5, 3, -23 };

		bubbleSort(arr);

		System.out.println(Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr) {

		boolean swapped; //keep track if swap is not happened in step then arr is sorted
		
		// run the steps N-1 times

		for (int i = 0; i < arr.length; i++) {
			swapped = false;
			// for each step Max no will come at last respective index

			for (int j = 1; j < arr.length - i; j++) {

				// swap if item is smaller than prev item
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}

	}

}
