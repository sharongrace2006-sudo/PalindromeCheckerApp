import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerUC6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both Stack and Queue
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        // Compare pop and dequeue operations
        for (int i = 0; i < input.length(); i++) {

            char stackChar = stack.pop();
            char queueChar = queue.remove();

            if (stackChar != queueChar) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}