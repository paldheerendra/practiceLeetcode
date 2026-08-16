package leetpractice.easyproblems;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(reverseArray(arr)));
    }

    private static int[] reverseArray(int[] arr) {
            for(int i =0 ; i < (arr.length +1 ) / 2; i++){
                int temp = arr[i] ;
                arr[i] = arr[arr.length -i-1 ] ;
                arr[arr.length -i-1 ] = temp;
            }
            return arr;


    }

}
