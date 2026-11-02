package gfg.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWith2Distinct904 {
    //https://www.geeksforgeeks.org/problems/longest-subarray-with-atmost-two-distinct-integers/1

    public static int longestSubarrayWith2Distinct(int[] arr) {
        int ans = 0;
        int left =0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < arr.length; right++ ){
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while(map.size() > 2){
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(longestSubarrayWith2Distinct(arr)); // Output: 3

        int[] arr2 = {0, 1, 2, 2};
        System.out.println(longestSubarrayWith2Distinct(arr2)); // Output: 3

        int[] arr3 = {1, 2, 3, 2, 2};
        System.out.println(longestSubarrayWith2Distinct(arr3)); // Output: 4
    }
}
