package leetpractice.easyproblems;

public class LLRemoveDuplicates83 {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next distinct node
            }
        }

        return head;
    }



    public static void main(String[] args) {
        //Singly linked list: 1 -> 1 -> 2 -> 3 -> 3
        addLast(1);
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(3);
        addLast(4);
        display();
        deleteDuplicates(head);
        display();

    }

    private static ListNode head;
    private static ListNode tail;

    public static void addFirst(int value) {
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

    }
    public static void addLast(int value) {

        if (tail == null) {
            addFirst(value);
            return;
        }

        ListNode node = new ListNode(value);
        tail.next = node;
        tail = node;


    }
    public static void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

     // Definition for singly-linked list.
      public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
