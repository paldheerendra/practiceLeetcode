package leetpractice.easyproblems;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class SquareRoot {

    //https://leetcode.com/problems/sqrtx/
    //Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
    //The returned integer should be non-negative as well.

    public static void main(String[] args) {

        System.out.println(sqrt1(2147483647));
        System.out.println(binarySearchSqrt(65, 2));
        System.out.printf("%.2f" , binarySearchSqrt(65, 2));
    }
    public static int mySqrt(int x) {
        if (x ==0)
            return 0;
        long num =1 ;
        for(int i =2; i < x ; i++){
            long remainder = x / (i * i);
            if(remainder >= 1){
                num = i;
            }
            if(remainder ==0)
                break;
        }
        return (int)num;
    }

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

    static double binarySearchSqrt(int n, int precision){
        int s= 0 ;
        int e = n;
        double root = 0.0;
        while ( s <= e){
            int m = s + (e -s ) / 2;
            if(m * m == n){
                return m;
            }
            if(m * m > n){
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        double incr =0.1;
        for(int i =0 ; i < precision; i++){
            while (root * root <= n){
                root += incr;
            }

            root -= incr;
            incr /= 10;
        }
        return root;

    }
}
