package leetpractice.mediumproblems;

public class MaximumSubarray53 {
    public static int maxSubArray(int[] nums) {
        if(nums.length <=1){
            return nums[0];
        }
        int result = nums[0];
        int temp = nums[0];
        for(int i =1 ; i < nums.length ; i++){
            temp = Math.max(temp, 0) + nums[i];
            result = Math.max(result, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

}
