package leetpractice.mediumproblems;

public class StringtoInteger8 {
    //https://leetcode.com/problems/string-to-integer-atoi/description/

    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }
    private static int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int sign = 1;
        long temp = 0;
        int i = 0;
        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            sign = s.charAt(0) == '-' ? -1 : 1;
            i++;
        }
        while(i < s.length()){
            if(s.charAt(i) < '0' || s.charAt(i) > '9')
                break;
            if(temp > Integer.MAX_VALUE /10 || temp < Integer.MIN_VALUE / 10){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            temp = 10 * temp + (s.charAt(i) - '0');
            i++;
        }
        temp = temp * sign;
        if(temp > Integer.MAX_VALUE)
            return (int) ((temp - 1));
        if(temp < Integer.MIN_VALUE)
            return (int) ((temp + 1));
        return (int) (temp);
    }
}
