package leetpractice.easyproblems;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArray26 {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums));
    }

    // 2 pointer solution
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // This method uses a HashSet to remove duplicates, but it does not maintain the order of elements and is less efficient than the two-pointer approach above.
    public static int removeDuplicates1(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<Integer>(list);
        int temp = 0;
        for(int a : set){
            nums[temp] = a;
            temp += 1;
        }
        for(int i = temp ; i < nums.length ; i++){
            nums[i] = 0;
        }
        return set.size();
    }
}
