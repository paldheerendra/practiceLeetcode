package sortingalgo;

import java.util.Arrays;

public class InsertionSort {

	
	public static void main(String[] args) {
		int[] arr = { 20, 0, 1, 2, 4, 5, 3, -23 };

		insertionSort(arr);

		System.out.println(Arrays.toString(arr));

	}
	
	//for every index put that index element at the correct index of LHS
	
	public static void insertionSort(int[] arr) {
		for(int i =0 ; i < arr.length - 1; i++) {
			
			for(int j = i + 1; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else {
					break;
				}
			}
		}
	}

}
