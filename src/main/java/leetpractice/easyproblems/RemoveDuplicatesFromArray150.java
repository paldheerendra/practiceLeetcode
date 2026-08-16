package leetpractice.easyproblems;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArray150 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
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
