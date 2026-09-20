package leetpractice.hardproblems;

import leetpractice.mediumproblems.LLReverseII_92;

public class LLReverseNodesKGroup25 {

    //https://leetcode.com/problems/reverse-nodes-in-k-group/description/

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode current = head;

        while (current != null) {
            ListNode groupEnd = current;
            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            if (groupEnd == null) {
                break;
            }

            ListNode nextGroupHead = groupEnd.next;
            groupEnd.next = null;

            ListNode reversedHead = reverseList(current);
            prevGroupTail.next = reversedHead;

            current.next = nextGroupHead;
            prevGroupTail = current;
            current = nextGroupHead;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }


    public static void main(String[] args) {
        //Singly linked list: 1 -> 2 -> 3 -> 4 -> 5
        LLReverseNodesKGroup25 list = new LLReverseNodesKGroup25();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Original List:");
        list.display();

        // Reverse the linked list in groups of k
        int k = 2;
        ListNode reversedHead = list.reverseKGroup(list.head, k);

        // Display the reversed linked list
        System.out.println("Reversed List in groups of " + k + ":");
        LLReverseNodesKGroup25 reversedList = new LLReverseNodesKGroup25();
        reversedList.head = reversedHead;
        reversedList.display();
    }


    //add LastNode to the end of the list
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

    //display the linked list
    public void display() {
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
