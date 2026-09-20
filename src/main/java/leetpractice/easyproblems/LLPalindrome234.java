package leetpractice.easyproblems;

public class LLPalindrome234 {

    //https://leetcode.com/problems/palindrome-linked-list/description/

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single node or empty list is a palindrome
        }

        // Find the middle of the linked list
        ListNode mid = middleNode(head);

        // Reverse the second half of the linked list
        ListNode secondHalfStart = reverseList(mid);

        // Compare the first half and the reversed second half
        ListNode firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                return false; // Not a palindrome
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true; // It's a palindrome
    }

    //find middle of the linked list //LLMiddle876
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // The middle node
    }

    //reverse the linked list //LLReverse206
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev forward
            current = nextTemp; // Move current forward
        }
        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        //Singly linked list: 1 -> 2 -> 3 -> 2 -> 1
        LLPalindrome234 list = new LLPalindrome234();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        System.out.println("Original List:");
        list.display();

        // Check if the linked list is a palindrome
        boolean isPalin = list.isPalindrome(list.head);
        System.out.println("Is Palindrome: " + isPalin);
    }

    //add node to the end of the list
    private ListNode head;
    private ListNode tail;

    public void addLast(int value) {

        if (tail == null) {
            head = new ListNode(value);
            tail = head;
            return;
        }
        ListNode node = new ListNode(value);
        tail.next = node;
        tail = node;

    }

    //display the list
    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
