package leetpractice.mediumproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums ={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        //o/p = [[-1,-1,2],[-1,0,1]]
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums.length < 3 || nums==null){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2 && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];
                if (x < 0) {
                    ++j;
                } else if (x > 0) {
                    --k;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        --k;
                    }
                }
            }
        }
        return result;
    }
}
