package collections.linkedlist;

public class Main {

    public static void main(String[] args) {
        SinglyLL list = new SinglyLL();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(100);
        list.display(); // Output: 100 -> 30 -> 20 -> 10 -> null

        list.addLast(300);
        list.display();

        list.add(200, 3);
        list.display();

        System.out.println("deleted first: " + list.deleteFirst());
        list.display();

        System.out.println("deleted last:" + list.deleteLast());
        list.display();

        System.out.println("Deleted index value: " + list.delete(2));
        list.display();

        list.addRec(500, 2);
        list.display();


        System.out.println("\nDoubly linked list...");
        DoublyLL dList = new DoublyLL();
        dList.addFirst(10);
        dList.addFirst(20);
        dList.addFirst(30);
        dList.addFirst(100);
        dList.display(); // Output: 100 <-> 30 <-> 20 <-> 10 <-> null

        dList.addLast(300);
        dList.display();

        dList.add(200, 3);
        dList.display();

        System.out.println("\nCircular linked list...");
        CircularLL cList = new CircularLL();
        cList.add(10);
        cList.add(20);
        cList.add(30);
        cList.add(100);
        cList.add(300);
        cList.display(); // Output: 300 -> 100 -> 30 -> 20 -> 10 -> (back to head)

        cList.delete(30);
        cList.display(); // Output: 300 -> 100 -> 20 -> 10 -> (back to head)


        cList.delete1(20);
        cList.display(); // Output: 300 -> 100 -> 10 -> (back to head)

    }
}
