package gfg.easy;

public class MaxConsecutiveBit {
    //https://www.geeksforgeeks.org/problems/max-consecutive-one/1

    //sliding window solution
    public static int maxConsecBits(int[] arr) {
        int max_len = 0;
        int zero_count = 0;
        int one_count = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 1) {
                one_count++;
                zero_count = 0;
                max_len = Math.max(max_len, one_count);
            } else {
                zero_count++;
                one_count = 0;
                max_len = Math.max(max_len, zero_count);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,0,1};

        System.out.println(maxConsecBits(arr));
    }
}
