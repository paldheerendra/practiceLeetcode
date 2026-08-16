package leetpractice.mediumproblems;

import java.util.Arrays;

public class RotateArray189 {
    public static void rotate(int[] nums, int k) {

        int lastIndex = nums.length - 1;
        for(int i = 0; i < k; i++){
            int temp = nums[lastIndex];
            for (int j = 0; j < lastIndex - 1 ; j++){
                nums[i++] = nums[i];
            }
            nums[0] = temp;
           // --lastIndex;
        }

    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        rotate(nums , k);
        System.out.println(Arrays.toString(nums));
    }
}
