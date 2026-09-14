package leetpractice.easyproblems;

public class LLCyclePresent141 {
    //https://leetcode.com/problems/linked-list-cycle/description/
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Singly linked list: 3 -> 2 -> 0 -> -4
        LLCyclePresent141 list = new LLCyclePresent141();
        list.addLast(3);
        list.addLast(2);
        list.addLast(0);
        list.addLast(-4);
        list.display();

        // Creating a cycle for testing
        list.tail.next = list.head.next; // Creating a cycle (tail points to the second node)

        System.out.println("Has cycle: " + hasCycle(list.head));
    }

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