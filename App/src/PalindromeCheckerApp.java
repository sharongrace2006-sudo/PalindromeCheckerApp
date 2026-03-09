import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Scanner;

public class PalindromePerformanceComparison {

    // Stack-based palindrome check
    public static boolean stackCheck(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based palindrome check
    public static boolean dequeCheck(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // Two-pointer check
    public static boolean twoPointerCheck(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Recursive check
    public static boolean recursiveCheck(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        return recursiveHelper(normalized, 0, normalized.length() - 1);
    }

    private static boolean recursiveHelper(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveHelper(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to test performance: ");
        String input = scanner.nextLine();

        // Array of algorithms
        String[] algorithms = {"Stack", "Deque", "Two-Pointer", "Recursive"};
        boolean[] results = new boolean[algorithms.length];
        long[] times = new long[algorithms.length];

        // Measure performance
        for (int i = 0; i < algorithms.length; i++) {
            long start = System.nanoTime();
            switch (algorithms[i]) {
                case "Stack" -> results[i] = stackCheck(input);
                case "Deque" -> results[i] = dequeCheck(input);
                case "Two-Pointer" -> results[i] = twoPointerCheck(input);
                case "Recursive" -> results[i] = recursiveCheck(input);
            }
            long end = System.nanoTime();
            times[i] = end - start;
        }

        // Display results
        System.out.println("\nPerformance Comparison:");
        System.out.printf("%-12s %-12s %-15s%n", "Algorithm", "Result", "Time (ns)");
        System.out.println("----------------------------------------");
        for (int i = 0; i < algorithms.length; i++) {
            System.out.printf("%-12s %-12s %-15d%n",
                    algorithms[i],
                    results[i] ? "Palindrome" : "Not Palindrome",
                    times[i]);
        }

        scanner.close();
    }
}