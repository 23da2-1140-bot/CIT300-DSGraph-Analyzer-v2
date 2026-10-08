import java.util.Scanner;

/**
 * Main.java
 * Menu-driven console interface. Connects all the data structures together.
 * ALL MEMBERS: integration, validation and testing.
 */
public class Main {

    private static Scanner input = new Scanner(System.in);

    private static ArrayOperations arrayOps = new ArrayOperations();
    private static MyStack stack = new MyStack();
    private static MyQueue queue = new MyQueue();
    private static MyLinkedList linkedList = new MyLinkedList();
    private static MyGraph graph = new MyGraph();
    private static PerformanceComparison performance = new PerformanceComparison();

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 9) {
            showMainMenu();
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performance.display(); break;
                case 8: displayAllResults(); break;
                case 9: System.out.println("Goodbye!"); break;
                default: System.out.println("Please choose a number from 1 to 9.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ---------------------------------------------------------------
    // INPUT HELPERS
    // ---------------------------------------------------------------
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    // ---------------------------------------------------------------
    // 1. ARRAY MENU   (Member 1)
    // ---------------------------------------------------------------
    private static void arrayMenu() {
        int choice = -1;
        while (choice != 5) {
            System.out.println("--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1:
                    int insertValue = readInt("Value to insert: ");
                    if (arrayOps.insert(insertValue)) {
                        System.out.println("Inserted.");
                    } else {
                        System.out.println("Error: array is full.");
                    }
                    break;
                case 2:
                    int deleteValue = readInt("Value to delete: ");
                    if (arrayOps.delete(deleteValue)) {
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Error: value not found.");
                    }
                    break;
                case 3:
                    int searchValue = readInt("Value to search: ");
                    int idx = arrayOps.search(searchValue);
                    if (idx == -1) {
                        System.out.println("Not found.");
                    } else {
                        System.out.println("Found at index " + idx + ".");
                    }
                    break;
                case 4:
                    arrayOps.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------------------
    // 2. STACK MENU   (Member 2)
    // ---------------------------------------------------------------
    private static void stackMenu() {
        int choice = -1;
        while (choice != 5) {
            System.out.println("--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1:
                    int pushValue = readInt("Value to push: ");
                    stack.push(pushValue);
                    System.out.println("Pushed.");
                    break;
                case 2:
                    try {
                        System.out.println("Popped: " + stack.pop());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Top: " + stack.peek());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------------------
    // 3. QUEUE MENU   (Member 2)
    // ---------------------------------------------------------------
    private static void queueMenu() {
        int choice = -1;
        while (choice != 5) {
            System.out.println("--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek/Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1:
                    int enqueueValue = readInt("Value to enqueue: ");
                    queue.enqueue(enqueueValue);
                    System.out.println("Enqueued.");
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued: " + queue.dequeue());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Front: " + queue.peek());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------------------
    // 4. LINKED LIST MENU   (Member 3)
    // ---------------------------------------------------------------
    private static void linkedListMenu() {
        int choice = -1;
        while (choice != 5) {
            System.out.println("------------ LINKED LIST OPERATIONS ---------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1:
                    int insertValue = readInt("Value to insert: ");
                    linkedList.insert(insertValue);
                    System.out.println("Inserted.");
                    break;
                case 2:
                    int deleteValue = readInt("Value to delete: ");
                    if (linkedList.delete(deleteValue)) {
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Error: value not found.");
                    }
                    break;
                case 3:
                    int searchValue = readInt("Value to search: ");
                    int pos = linkedList.search(searchValue);
                    if (pos == -1) {
                        System.out.println("Not found.");
                    } else {
                        System.out.println("Found at position " + pos + ".");
                    }
                    break;
                case 4:
                    linkedList.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------------------
    // 5. SEARCHING MENU   (Member 1)
    // ---------------------------------------------------------------
    private static void searchingMenu() {
        int choice = -1;
        while (choice != 3) {
            System.out.println("------------ SEARCHING OPERATIONS -----------");
            System.out.println("(Uses the current values in the Array component)");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Return to Main Menu");
            choice = readInt("Enter your choice: ");
            System.out.println();

            int[] values = arrayOps.toArray();
            if (values.length == 0 && choice != 3) {
                System.out.println("The array is empty. Add values using Array Operations > Insert first.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1: {
                    int target = readInt("Value to search: ");
                    SearchOperations.SearchResult result = SearchOperations.linearSearch(values, target);
                    printSearchResult("Linear Search", result);
                    performance.record("Search", "Linear Search", result.steps);
                    break;
                }
                case 2: {
                    int target = readInt("Value to search: ");
                    int[] sorted = SearchOperations.sortedCopy(values);
                    System.out.println("(Array sorted for binary search: " + java.util.Arrays.toString(sorted) + ")");
                    SearchOperations.SearchResult result = SearchOperations.binarySearch(sorted, target);
                    printSearchResult("Binary Search", result);
                    performance.record("Search", "Binary Search", result.steps);
                    break;
                }
                case 3:
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 3.");
            }
            System.out.println();
        }
    }

    private static void printSearchResult(String name, SearchOperations.SearchResult result) {
        if (result.found) {
            System.out.println(name + ": found at index " + result.index + " in " + result.steps + " step(s).");
        } else {
            System.out.println(name + ": not found. Took " + result.steps + " step(s).");
        }
    }

    // ---------------------------------------------------------------
    // 6. GRAPH MENU   (Member 4)
    // ---------------------------------------------------------------
    private static void graphMenu() {
        int choice = -1;
        while (choice != 6) {
            System.out.println("--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1: {
                    int vertex = readInt("Vertex number to add: ");
                    if (graph.addVertex(vertex)) {
                        System.out.println("Vertex added.");
                    } else {
                        System.out.println("Error: vertex already exists.");
                    }
                    break;
                }
                case 2: {
                    int a = readInt("First vertex: ");
                    int b = readInt("Second vertex: ");
                    if (graph.addEdge(a, b)) {
                        System.out.println("Edge added.");
                    } else {
                        System.out.println("Error: both vertices must exist, be different, and the edge must not already exist.");
                    }
                    break;
                }
                case 3:
                    graph.display();
                    break;
                case 4: {
                    int start = readInt("Start vertex for BFS: ");
                    if (!graph.hasVertex(start)) {
                        System.out.println("Error: vertex not found.");
                        break;
                    }
                    MyGraph.TraversalResult result = graph.bfs(start);
                    System.out.println("BFS order: " + result.order + " (" + result.steps + " step(s))");
                    performance.record("Graph Traversal", "BFS", result.steps);
                    break;
                }
                case 5: {
                    int start = readInt("Start vertex for DFS: ");
                    if (!graph.hasVertex(start)) {
                        System.out.println("Error: vertex not found.");
                        break;
                    }
                    MyGraph.TraversalResult result = graph.dfs(start);
                    System.out.println("DFS order: " + result.order + " (" + result.steps + " step(s))");
                    performance.record("Graph Traversal", "DFS", result.steps);
                    break;
                }
                case 6:
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 6.");
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------------------
    // 8. DISPLAY ALL RESULTS   (Integration)
    // ---------------------------------------------------------------
    private static void displayAllResults() {
        System.out.println("===== Array =====");
        arrayOps.display();
        System.out.println("\n===== Stack =====");
        stack.display();
        System.out.println("\n===== Queue =====");
        queue.display();
        System.out.println("\n===== Linked List =====");
        linkedList.display();
        System.out.println("\n===== Graph =====");
        graph.display();
        System.out.println();
        performance.display();
    }
}
