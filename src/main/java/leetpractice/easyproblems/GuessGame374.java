package leetpractice.easyproblems;

public class GuessGame374 {

    //https://leetcode.com/problems/guess-number-higher-or-lower/

    public static void main(String[] args) {
       int n = 10;
       int pick = 6;
       System.out.println(guessNumber(n, 6));
    }
    /*static int guessNumber(int n) {
        if(guess(int num))
    }*/
    static int guess(int n){
        int start = 1;
        int end = n;
        while (start < end) {
            int mid  = start + (end - start)/2 ;
            if (guess(mid) <= 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int guessNumber(int n, int pick) {
        int start = 1;
        int end = n;
        int result = 1;
        while (start < end) {
            int mid  = start + (end - start)/2 ;
            if (guess(mid) < 0) {
                start = mid + 1;
            } else if(guess(mid) > 0) {
                end = mid - 1;
            } else{
                result = mid;
            }
        }
        return result;

    }
}
