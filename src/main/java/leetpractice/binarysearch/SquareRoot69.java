package leetpractice.binarysearch;


public class SquareRoot69 {
    //https://leetcode.com/problems/sqrtx/description/
    //Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
    //The returned integer should be non-negative as well.

    //binary search approach
    static double mySqrt(int x){
        if(x <= 1)
            return x;
        long start= 1 ;
        long end = x/2;

        while ( start <= end){
            long mid = start + (end -start ) / 2;
            long sq = mid * mid;
            if(sq == x){
                return (int)mid;
            }
            if(sq > x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (int)end;
    }

    //brute force approach
    static int sqrt1(int x){
        if (x <= 1)
            return x;
        long num = 1;
        long sq = num * num;
        while (x >= sq) {
            num++;
            sq = num * num;
        }
        return (int) (num - 1);
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(sqrt1(x));
        System.out.println(mySqrt(x));
    }
}
