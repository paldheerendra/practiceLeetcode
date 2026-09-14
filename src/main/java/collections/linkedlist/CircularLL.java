package collections.linkedlist;

public class CircularLL {

    private int size;
    private Node head;
    private Node tail;

    public CircularLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;// Make it circular
            return;
        }
        node.next = head;
        head = node;
        tail.next = head; // Update tail's next to new head

        size++;
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        Node prev = tail; // Start with tail since it's circular

        do {
            if (current.value == value) {
                if (current == head) {
                    head = head.next;
                    tail.next = head; // Update tail's next to new head
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head; // Update tail's next to head
                } else {
                    prev.next = current.next; // Bypass the current node
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Value " + value + " not found in the list");
    }

    public void delete1(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node node = head;
        if(node .value == value) {
            head = head.next;
            tail.next = head;
            size--;
            return;
        }
        do{
            Node nextNode = node.next;
            if(nextNode.value == value) {
                node.next = nextNode.next;
                break;
        }
            node = nextNode;
        } while (node != head);

    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
