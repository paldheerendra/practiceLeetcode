package leetpractice.mediumproblems;

public class IntegerToRoman12 {
    //https://leetcode.com/problems/integer-to-roman/description/
    private static final int[] VALUES = {1000, 500, 100, 50, 10, 5, 1};
    private static final String[] SYMBOLS = {"M", "D", "C", "L", "X", "V", "I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < VALUES.length; i++) {
            if (i == 1 && num >= VALUES[2] * 9) {
                num -= VALUES[2] * 9;
                sb.append(SYMBOLS[2]).append(SYMBOLS[0]);
            } else if (i == 2 && num >= VALUES[2] * 4) {
                num -= VALUES[2] * 4;
                sb.append(SYMBOLS[2]).append(SYMBOLS[1]);
            } else if (i == 3 && num >= VALUES[4] * 9) {
                num -= VALUES[4] * 9;
                sb.append(SYMBOLS[4]).append(SYMBOLS[2]);
            } else if (i == 4 && num >= VALUES[4] * 4) {
                num -= VALUES[4] * 4;
                sb.append(SYMBOLS[4]).append(SYMBOLS[3]);
            } else if (i == 5 && num >= VALUES[6] * 9) {
                num -= VALUES[6] * 9;
                sb.append(SYMBOLS[6]).append(SYMBOLS[4]);
            } else if (i == 6 && num >= VALUES[6] * 4) {
                num -= VALUES[6] * 4;
                sb.append(SYMBOLS[6]).append(SYMBOLS[5]);
            }
            int count = num / VALUES[i];
            for (int j = 0; j < count; j++) {
                sb.append(SYMBOLS[i]);
            }
            num %= VALUES[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 3749;
        String roman = IntegerToRoman12.intToRoman(num);
        System.out.println(roman); // Output: MMMDCCXLIX
    }
}
