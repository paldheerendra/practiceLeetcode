package leetpractice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets904 {

    //https://leetcode.com/problems/fruit-into-baskets/description/

    //sliding window solution
    public static int totalFruit(int[] fruits) {
        int ans = 0, left =0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++ ){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
    //brute force solution - TLE
    public static int totalFruit1(int[] fruits) {
        int ans = 0;
        for (int left =0 ; left < fruits.length ; left++ ){
            Map<Integer, Integer> map = new HashMap<>();
            for (int right = left ; right < fruits.length ; right++ ){
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                if(map.size() > 2){
                    break;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        System.out.println(totalFruit(fruits)); // Output: 3

        int[] fruits2 = {0,1,2,2};
        System.out.println(totalFruit(fruits2)); // Output: 3

        int[] fruits3 = {1,2,3,2,2};
        System.out.println(totalFruit(fruits3)); // Output: 4
    }
}
