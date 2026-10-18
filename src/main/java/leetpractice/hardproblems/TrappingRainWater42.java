package leetpractice.hardproblems;

public class TrappingRainWater42 {
    //https://leetcode.com/problems/trapping-rain-water/description/

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int water = 0, left_max = height[left], right_max = height[right];
        while (left < right) {
           if(left_max < right_max) {
               left ++;
               left_max = Math.max(left_max, height[left]);
               water += left_max - height[left];
            } else {
               right--;
                right_max = Math.max(right_max, height[right]);
                water += right_max - height[right];

            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height)); // Output: 6
    }
}
