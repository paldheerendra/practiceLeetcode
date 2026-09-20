package leetpractice.mediumproblems;

import leetpractice.easyproblems.LLReverse206;

public class LLReverseII_92 {

    //https://leetcode.com/problems/reverse-linked-list-ii/description/

    //Input: head = [1,2,3,4,5], left = 2, right = 4
    //Output: [1,4,3,2,5]

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        //Singly linked list: 1 -> 2 -> 3 -> 4 -> 5
        LLReverseII_92 list = new LLReverseII_92();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Original List:");
        list.display();

        // Reverse the linked list from position left to right
        int left = 2;
        int right = 4;
        ListNode reversedHead = list.reverseBetween(list.head, left, right);

        // Display the reversed linked list
        System.out.println("Reversed List from position " + left + " to " + right + ":");
        LLReverseII_92 reversedList = new LLReverseII_92();
        reversedList.head = reversedHead;
        reversedList.display();
    }

    //add node to the end of the list
    private ListNode head;
    private ListNode tail;

    private void addLast(int value) {
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
    private void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
