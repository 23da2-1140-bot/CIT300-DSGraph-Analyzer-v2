
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * MyGraph.java
 * MEMBER 4: Graph component.
 * Represented with an adjacency list: each vertex has a list of its neighbours.
 * Edges are two-way (undirected). Also counts steps for BFS/DFS for the
 * Performance Comparison menu.
 */
public class MyGraph {

    private LinkedHashMap<Integer, ArrayList<Integer>> adjacencyList =
            new LinkedHashMap<>();

    // Result of a traversal: the order visited and number of steps.
    public static class TraversalResult {
        public ArrayList<Integer> order;
        public int steps;

        public TraversalResult(ArrayList<Integer> order, int steps) {
            this.order = order;
            this.steps = steps;
        }
    }

    // Check whether a vertex exists.
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Check whether an edge exists between two vertices.
    public boolean hasEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) {
            return false;
        }

        return adjacencyList.get(a).contains(b);
    }

    // Add a vertex. Returns false if it already exists.
    public boolean addVertex(int vertex) {
        if (hasVertex(vertex)) {
            return false;
        }

        adjacencyList.put(vertex, new ArrayList<Integer>());
        return true;
    }

    // Add a two-way edge. Returns false if a vertex is missing,
    // both vertices are the same, or the edge already exists.
    public boolean addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b) || a == b) {
            return false;
        }

        if (hasEdge(a, b)) {
            return false;
        }

        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
        return true;
    }

    // Display each vertex and the list of its connected neighbours
    public void display() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph has no vertices yet.");
            return;
        }

        for (Integer vertex : adjacencyList.keySet()) {
            ArrayList<Integer> neighbours = adjacencyList.get(vertex);
            System.out.println(vertex + " -> " + neighbours);
        }
    }

    // Visit vertices level by level, using a queue to track the next vertex.
    public TraversalResult bfs(int start) {
        ArrayList<Integer> order = new ArrayList<>();
        int steps = 0;

        if (!hasVertex(start)) {
            return new TraversalResult(order, steps);
        }

        ArrayList<Integer> visited = new ArrayList<>();
        MyQueue queue = new MyQueue();

        visited.add(start);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            steps++;
            order.add(current);

            for (int neighbour : adjacencyList.get(current)) {
                steps++;

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.enqueue(neighbour);
                }
            }
        }

        return new TraversalResult(order, steps);
    }

    // Explore each path deeply before backtracking to unvisited vertices.
    public TraversalResult dfs(int start) {
        ArrayList<Integer> order = new ArrayList<>();
        int[] steps = {0};

        if (hasVertex(start)) {
            ArrayList<Integer> visited = new ArrayList<>();
            dfsVisit(start, visited, order, steps);
        }

        return new TraversalResult(order, steps[0]);
    }

    // Recursive helper method for DFS.
    private void dfsVisit(
            int current,
            ArrayList<Integer> visited,
            ArrayList<Integer> order,
            int[] steps) {

        visited.add(current);
        order.add(current);
        steps[0]++;

        for (int neighbour : adjacencyList.get(current)) {
            steps[0]++;

            if (!visited.contains(neighbour)) {
                dfsVisit(neighbour, visited, order, steps);
            }
        }
    }

    // Return the number of vertices.
    public int vertexCount() {
        return adjacencyList.size();
    }
}

