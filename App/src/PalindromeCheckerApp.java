import java.util.Scanner;

public class NormalizedPalindromeChecker {

    // Method to normalize input string
    public static String normalizeString(String input) {
        // Convert to lowercase and remove non-alphanumeric characters
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Two-pointer palindrome check
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = normalizeString(input);

        if (isPalindrome(normalized)) {
            System.out.println("The string is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string is NOT a Palindrome (ignoring case and spaces).");
        }

        scanner.close();
    }
}