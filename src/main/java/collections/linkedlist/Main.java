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


    }
}
