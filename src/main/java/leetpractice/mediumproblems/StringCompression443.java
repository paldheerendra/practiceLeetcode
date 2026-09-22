package leetpractice.mediumproblems;

import java.util.HashMap;
import java.util.Map;

public class StringCompression443 {
    //https://leetcode.com/problems/string-compression/description/

    public int compress(char[] chars) {
        int index = 0;
        int count = 1;

        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }
                count = 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {

        StringCompression443 sc = new StringCompression443();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = sc.compress(chars);
        System.out.println(length);
    }
}
