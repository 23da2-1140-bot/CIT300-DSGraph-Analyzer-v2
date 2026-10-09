/**
 * ArrayOperations.java
 * MEMBER 1: Array component.
 * Uses a fixed-size array and keeps track of how many slots are filled.
 */
public class ArrayOperations {

    private static final int CAPACITY = 50;
    private int[] data = new int[CAPACITY];
    private int size = 0;

   // Tested: insert adds a value at the end successfully
    public boolean insert(int value) {
        if (size >= CAPACITY) {
            return false;
        }
        data[size] = value;
        size++;
        return true;
    }

    // Delete the first occurrence of a value. Returns false if not found.
    // Tested: delete removes the value and shifts the remaining items left; returns false if the value is not found
    public boolean delete(int value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        // Shift every element after it one step to the left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    // Linear search for a value. Returns its index, or -1 if not found.
    // Tested: search checks each position from the start and returns the index, or -1 if not found
    public int search(int value) {
        return indexOf(value);
    }

    private int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Show every value currently in the array
    // Tested: display prints the filled slots of the array
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size >= CAPACITY; }

    // Returns a copy of the filled part of the array (used by Searching and Performance)
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }
}
