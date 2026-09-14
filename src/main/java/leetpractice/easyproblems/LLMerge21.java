package leetpractice.easyproblems;

public class LLMerge21 {

    //https://leetcode.com/problems/merge-two-sorted-lists/description/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        //Singly linked list: 1 -> 2 -> 4
        LLMerge21 list1 = new LLMerge21();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(4);
        list1.display();

        ListNode l1 = list1.head;

        //Singly linked list: 1 -> 3 -> 4
        LLMerge21 list2 = new LLMerge21();
        list2.addLast(1);
        list2.addLast(3);
        list2.addLast(4);
        list2.display();

        ListNode l2 = list2.head;

        LLMerge21 mergedList = new LLMerge21();
        mergedList.head = mergeTwoLists(l1, l2);
        mergedList.display();

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
