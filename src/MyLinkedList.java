/**
 * MyLinkedList.java
 * MEMBER 3: Linked List component.
 * A singly linked list of integers.
 *
 * Insert at the end, delete the first match, search, and display.
 */
public class MyLinkedList {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    // Insert a value at the end of the list
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Delete the first occurrence of a value. Returns false if not found.
    public boolean delete(int value) {
        if (head == null) {
            return false;
        }
        if (head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Search for the first occurrence. Returns its position, or -1 if not found.
    // Position 0 is the first node, same as an array index.
    public int search(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.value == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    // Show every value in the list
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.print("Linked list: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}
