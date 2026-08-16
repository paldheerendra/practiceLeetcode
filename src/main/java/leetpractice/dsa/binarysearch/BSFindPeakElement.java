package leetpractice.dsa.binarysearch;

public class BSFindPeakElement {

    //https://leetcode.com/problems/find-peak-element
    public static void main(String[] args) {
        //1,2,1,3,5,6,4
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = 0;
        int index = 0;
        if(arr.length <= 1){
            index = 0;
        }else if(arr.length == 2){
            if(arr[0] < arr[1])
                index = 1;
            else
                index = 0;
        }else {
            end = arr.length - 1;
            while(start <= end){
                int mid  = start + (end - start)/2 ;
                if(arr[mid -1] < arr[mid] && arr[mid + 1] < arr[mid]){
                    return mid;
                }else if(arr[mid -1] < arr[mid] && arr[mid + 1] > arr[mid]){
                    start = mid + 1;
                }else if(arr[mid -1] > arr[mid] && arr[mid + 1] < arr[mid]){
                    end = mid - 1;
                }
            }
        }

        return index;
    }
}
