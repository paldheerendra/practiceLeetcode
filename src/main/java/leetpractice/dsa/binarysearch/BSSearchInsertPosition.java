package leetpractice.dsa.binarysearch;


public class BSSearchInsertPosition {
    //https://leetcode.com/problems/search-insert-position/description/
    public static void main(String[] args) {
        int [] arr = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int index = 0;
        while(start <= end){
            int mid  = start + (end - start)/2 ;
            if(target < arr[mid]){
                end = mid - 1;
                index = mid ;
            }else if(target > arr[mid]){
                start = mid + 1 ;
                index = mid + 1;
            }else{
                return mid;
            }
        }
        return index;
    }
}
