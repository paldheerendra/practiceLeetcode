package leetpractice;

public class desaw {

    /*Table
    Given a row and a column, I want you to find the element of the table

    the table only contains '0' and '1'

    The first row looks like this
            0
    For every row after
        - iterate the previous row, if you see a 0 append 01, if you see a 1 append 10

            0
            01
            0110
            01101001
            0110100110010110
            01101001100101101001011001101001

    the next row - first half is the prvious row and the second half is the invertion of the prev
    for the nth row -- the number of elements is 2**next*/

    static int getElement(int row, int col) {
        if (row == 0) {
            return 0;
        }
        int mid = (1 << row) / 2; // Calculate the midpoint of the current row
        if (col < mid) {
            return getElement(row - 1, col); // If col is in the first half, recurse on the previous row
        } else {
            return 1 - getElement(row - 1, col - mid); // If col is in the second half, invert the result from the previous row
        }
    }


    public static void main(String[] args) {
        int row = 4; // Example row
        int col = 12; // Example column
        int element = getElement(row, col);
        System.out.println("Element at row " + row + ", column " + col + " is: " + element);
    }
}
