/**
 * SearchOperations.java
 * MEMBER 1: Searching component.
 * Provides linear search and binary search, and counts the steps each one takes
 * so the Performance Comparison menu can show the difference.
 */
public class SearchOperations {

    // Result of a search: whether it was found, its index, and how many steps it took.
    public static class SearchResult {
        public boolean found;
        public int index;
        public int steps;

        public SearchResult(boolean found, int index, int steps) {
            this.found = found;
            this.index = index;
            this.steps = steps;
        }
    }

    // Linear search: checks each element one by one until it finds the value.
    // Tested: linear search checks items one by one, so it works on any array; time complexity is O(n)
    public static SearchResult linearSearch(int[] values, int target) {
        int steps = 0;
        for (int i = 0; i < values.length; i++) {
            steps++;
            if (values[i] == target) {
                return new SearchResult(true, i, steps);
            }
        }
        return new SearchResult(false, -1, steps);
    }

    // Binary search: the array MUST be sorted first.
    // Repeatedly checks the middle of the remaining range and halves the search space.
    public static SearchResult binarySearch(int[] sortedValues, int target) {
        int steps = 0;
        int low = 0;
        int high = sortedValues.length - 1;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (sortedValues[mid] == target) {
                return new SearchResult(true, mid, steps);
            } else if (sortedValues[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(false, -1, steps);
    }

    // Returns a sorted copy of the given array (needed before binary search)
    public static int[] sortedCopy(int[] values) {
        int[] copy = values.clone();
        java.util.Arrays.sort(copy);
        return copy;
    }
}
