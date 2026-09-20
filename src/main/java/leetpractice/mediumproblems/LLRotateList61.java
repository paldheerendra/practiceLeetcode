package leetpractice.mediumproblems;

public class LLRotateList61 {

    //https://leetcode.com/problems/rotate-list/description/

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        // First, determine the length of the list
        ListNode current = head;
        int length = 1; // Start with 1 to count the head
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the last node to the head to make it circular
        current.next = head;

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        k = k % length;
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;
        newTail.next = null; // Break the circle

        return head;
    }

    public static void main(String[] args) {
        //Singly linked list: 1 -> 2 -> 3 -> 4 -> 5
        LLRotateList61 list = new LLRotateList61();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Original List:");
        list.display();

        // Rotate the linked list to the right by k places
        int k = 2;
        ListNode rotatedHead = list.rotateRight(list.head, k);

        // Display the rotated linked list
        System.out.println("Rotated List by " + k + " positions:");
        LLRotateList61 rotatedList = new LLRotateList61();
        rotatedList.head = rotatedHead;
        rotatedList.display();
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
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
