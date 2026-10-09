/**
 * MyStack.java
 * MEMBER 2: Stack component (LIFO - Last In, First Out).
 * Built using a singly linked structure, so it has no fixed size limit.
 */
public class MyStack {

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node top;
    private int size;

    // Add a value on top of the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove and return the top value. Throws if the stack is empty.
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // Look at the top value without removing it. Throws if the stack is empty.
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return top.value;
    }

    public boolean isEmpty() { return top == null; }
    public int getSize() { return size; }

    // Show the stack from top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top -> bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
