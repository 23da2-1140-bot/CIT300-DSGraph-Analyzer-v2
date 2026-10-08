import java.util.ArrayList;

/**
 * PerformanceComparison.java
 * ALL MEMBERS / INTEGRATION: records results from Searching and Graph
 * traversal so they can be displayed together in one table (menu options
 * 7 and 8). This is the "Performance/Complexity Demonstration" requirement.
 */
public class PerformanceComparison {

    // One row of the results table
    private static class Record {
        String operation;
        String algorithm;
        int steps;
        Record(String operation, String algorithm, int steps) {
            this.operation = operation;
            this.algorithm = algorithm;
            this.steps = steps;
        }
    }

    private ArrayList<Record> records = new ArrayList<>();

    public void record(String operation, String algorithm, int steps) {
        records.add(new Record(operation, algorithm, steps));
    }

    public void display() {
        System.out.println("=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        if (records.isEmpty()) {
            System.out.println("No results recorded yet. Run a search or a");
            System.out.println("graph traversal first (menu options 5 and 6).");
            return;
        }
        System.out.printf("%-18s %-16s %s%n", "Operation", "Algorithm", "Steps");
        System.out.println("------------------------------------------------");
        for (Record r : records) {
            System.out.printf("%-18s %-16s %d%n", r.operation, r.algorithm, r.steps);
        }
        System.out.println("=============================================");
    }
}
