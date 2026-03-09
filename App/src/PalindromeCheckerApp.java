import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {

    // Encapsulated method to check palindrome
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        // Normalize string: lowercase and remove non-alphanumeric
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Use stack to reverse characters
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare original and reversed characters
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome (checked via PalindromeChecker class).");
        } else {
            System.out.println("The string is NOT a Palindrome (checked via PalindromeChecker class).");
        }

        scanner.close();
    }
}