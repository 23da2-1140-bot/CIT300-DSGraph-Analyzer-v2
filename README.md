# Data Structure and Graph Performance Analyzer

CIT300 Data Structures and Algorithms - Graded Practical Assignment 2

A Java console application demonstrating arrays, stacks, queues, linked lists,
searching algorithms, and graph traversal, with a performance comparison
feature.

## Group Members

| Name | Student ID | Responsibility | Individual Contribution |
|------|-----------|----------------|-------------------------|
| (Member 1 name) | (ID) | Array and Searching | (write what you did) |
| (Member 2 name) | (ID) | Stack and Queue | (write what you did) |
| (Member 3 name) | (ID) | Linked List | (write what you did) |
| (Member 4 name) | (ID) | Graph and traversal | (write what you did) |

All members worked together on: Performance Comparison, main menu, integration, testing, documentation.

## Components

| Component | File | Operations |
|-----------|------|------------|
| Array | ArrayOperations.java | Insert, Delete, Search, Display |
| Stack | MyStack.java | Push, Pop, Peek, Display (handles empty stack) |
| Queue | MyQueue.java | Enqueue, Dequeue, Peek, Display (handles empty queue) |
| Linked List | MyLinkedList.java | Insert, Delete, Search, Display |
| Searching | SearchOperations.java | Linear Search, Binary Search |
| Graph | MyGraph.java | Add Vertex, Add Edge, Display, BFS, DFS |
| Performance | PerformanceComparison.java | Records and displays step counts for searches and traversals |

## How to Run

1. Install JDK 17 or newer.
2. Open a terminal in the project folder.
3. Compile: `javac -d out src/*.java`
4. Run: `java -cp out Main`

## How to Use the Performance Comparison

1. Add some values using **Array Operations > Insert**.
2. Run **Searching Operations > Linear Search** and **Binary Search** on the same value.
3. Add vertices and edges using **Graph Operations**, then run **BFS Traversal** and **DFS Traversal**.
4. Open **Performance Comparison** (main menu option 7) to see a table comparing the number of steps each algorithm took.

## Input Validation

- Empty inputs and non-numeric menu choices are rejected.
- Duplicate array values can be inserted; delete removes the first match.
- Popping from an empty stack and dequeuing from an empty queue show an error instead of crashing.
- Searching for a missing value, or starting a graph traversal from a vertex that does not exist, shows an error.
- Adding a duplicate vertex or edge, or an edge to a missing vertex, is rejected.

## Demo Video

(Add the link here)
