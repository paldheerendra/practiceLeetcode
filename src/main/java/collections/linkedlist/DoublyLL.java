package collections.linkedlist;

public class DoublyLL {

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void addLast(int value) {
        if (tail == null) {
            addFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size += 1;
    }

    public void add(int value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        Node node = new Node(value);
        Node temp = get(index);
        node.next = temp;
        node.prev = temp.prev;
        temp.prev.next = node;
        temp.prev = node;
        size += 1;
    }
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("Reverse order:");
        temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
