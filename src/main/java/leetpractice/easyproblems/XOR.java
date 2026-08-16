package leetpractice.easyproblems;

public class XOR {
    public static void main(String[] args) {

     /* x	y	x^y
        0	0	0
        0	1	1
        1	0	1
        1	1   0
        */
        int[][] arr = {
                {0, 0, 1, 1},
                {0, 1, 0, 1},
        };
            for(int i = 0; i < arr[0].length ; i++) {
                System.out.println(arr[0][i] ^ arr[1][i]);
            }
    }
}
