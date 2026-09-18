package leetpractice.easyproblems;

public class LLHappyNUmber202 {

    //https://leetcode.com/problems/happy-number/description/

    // this problem can be solved using the Floyd's Cycle Detection Algorithm (also known as the Tortoise and Hare algorithm).
    // The idea is to use two pointers (slow and fast) to detect if there is a cycle in the sequence of numbers generated
    // by repeatedly replacing the number with the sum of the squares of its digits. If there is a cycle,
    // then the number is not happy; if we reach 1, then it is a happy number.

    //It's same as linked list cycle detection problem 141. We can use the same approach here. The slow pointer moves one step at a time,
    // while the fast pointer moves two steps at a time. If there is a cycle, the two pointers will eventually meet.

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getSquare(slow); // Move slow pointer by 1 step
            fast = getSquare(getSquare(fast)); // Move fast pointer by 2 steps
        } while (slow != fast);

        return slow == 1; // If they meet at 1, it's a happy number
    }
    private static int getSquare(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;

            totalSum += digit * digit;
            number /= 10;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int number = 12; // Example input
        if (isHappy(number)) {
            System.out.println(number + " is a happy number.");
        } else {
            System.out.println(number + " is not a happy number.");
        }
    }
}
