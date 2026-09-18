package leetpractice.mediumproblems;

public class LLSortList148 {

    //https://leetcode.com/problems/sort-list/description/

    // Merge Sort for Linked List
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Split the list into two halves
        ListNode mid = getMiddle(head);

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Merge the sorted halves
        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        // Find the middle of the list and split into two halves.
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Split the list into two parts: head...prev and slow...
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Append any remaining nodes
        current.next = (left != null) ? left : right;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Singly linked list: 4 -> 2 -> 1 -> 3
        LLSortList148 list = new LLSortList148();
        list.addLast(4);
        list.addLast(2);
        list.addLast(1);
        list.addLast(3);
        System.out.println("Original List:");
        list.display();

        // Sort the list
        ListNode sortedHead = list.sortList(list.head);
        System.out.println("Sorted List:");
        LLSortList148 sortedList = new LLSortList148();
        sortedList.head = sortedHead;
        sortedList.display();
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
