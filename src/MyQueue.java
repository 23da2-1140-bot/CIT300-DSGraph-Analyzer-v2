/**
 * MyQueue.java
 * MEMBER 2: Queue component (FIFO - First In, First Out).
 * Built using a singly linked structure with front and rear pointers.
 */
public class MyQueue {

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node front;
    private Node rear;
    private int size;

    // Add a value at the back of the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove and return the value at the front. Throws if the queue is empty.
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        int value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    // Look at the front value without removing it. Throws if the queue is empty.
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return front.value;
    }

    public boolean isEmpty() { return front == null; }
    public int getSize() { return size; }

    // Show the queue from front to back
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> back): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
