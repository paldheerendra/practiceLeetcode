package leetpractice.easyproblems;

public class SmallestMissingInteger2996 {

    //https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/

    public static int missingInteger(int[] nums) {
        int result = 0;
        if(nums.length == 1) {
            return nums[0] + 1;
        }
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if(i < nums.length -1 && (temp  <= nums[i +1])){
                result += nums[i] + (i - nums[i])/2;
            }else{
                //if(result )

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,2,5};
        /*Output: 6
        Input: nums = [3,4,5,1,12,14,13]
        Output: 15
        */
        System.out.println(missingInteger(arr));
    }
}
