package leetpractice.mediumproblems;

public class LLAddTwoNumbers2 {
    //https://leetcode.com/problems/add-two-numbers/description/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        //Singly linked list: 2 -> 4 -> 3
        LLAddTwoNumbers2 list1 = new LLAddTwoNumbers2();
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(3);
        System.out.println("List 1:");
        list1.display();

        ListNode l1 = list1.head;

        //Singly linked list: 5 -> 6 -> 4
        LLAddTwoNumbers2 list2 = new LLAddTwoNumbers2();
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(4);
        System.out.println("List 2:");
        list2.display();

        ListNode l2 = list2.head;

        LLAddTwoNumbers2 resultList = new LLAddTwoNumbers2();
        resultList.head = resultList.addTwoNumbers(l1, l2);
        System.out.println("Result List:");
        resultList.display();
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
