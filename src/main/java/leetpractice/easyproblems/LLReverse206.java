package leetpractice.easyproblems;

public class LLReverse206 {

    //https://leetcode.com/problems/reverse-linked-list/description/

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

        //Singly linked list: 1 -> 2 -> 3 -> 4 -> 5
        LLReverse206 list = new LLReverse206();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Original List:");
        list.display();

        // Reverse the linked list
        ListNode reversedHead = list.reverseList(list.head);

        // Display the reversed linked list
        System.out.println("Reversed List:");
        LLReverse206 reversedList = new LLReverse206();
        reversedList.head = reversedHead;
        reversedList.display();
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
