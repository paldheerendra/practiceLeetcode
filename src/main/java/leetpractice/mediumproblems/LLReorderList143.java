package leetpractice.mediumproblems;

public class LLReorderList143 {
    //https://leetcode.com/problems/reorder-list/description/
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode secondHalf = reverseList(mid.next);
        mid.next = null;
        mergeLists(head, secondHalf);
    }

    //merge two linked lists
    private void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }

    //find middle node of the linked list
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //reverse the linked list
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
        LLReorderList143 list = new LLReorderList143();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Original List:");
        list.display();

        list.reorderList(list.head);
        System.out.println("Reordered List:");
        list.display();
    }

    //add LastNode method to add a node at the end of the list
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

    //display method to print the linked list
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
