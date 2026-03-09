import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

// 1. Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// 2a. Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}

// 2b. Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 3. Context / Service class
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main Application
public class StrategyPatternPalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Choose strategy dynamically
        System.out.println("Choose Palindrome Algorithm:");
        System.out.println("1. Stack");
        System.out.println("2. Deque");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;
        switch (choice) {
            case 1 -> strategy = new StackStrategy();
            case 2 -> strategy = new DequeStrategy();
            default -> {
                System.out.println("Invalid choice, defaulting to Stack strategy.");
                strategy = new StackStrategy();
            }
        }

        PalindromeService service = new PalindromeService(strategy);
        boolean result = service.check(input);

        if (result) {
            System.out.println("The string is a Palindrome (using chosen strategy).");
        } else {
            System.out.println("The string is NOT a Palindrome (using chosen strategy).");
        }

        scanner.close();
    }
}