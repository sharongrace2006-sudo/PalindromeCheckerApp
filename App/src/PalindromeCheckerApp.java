import java.util.Scanner;

public class RecursivePalindromeChecker {

    // Recursive function
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}