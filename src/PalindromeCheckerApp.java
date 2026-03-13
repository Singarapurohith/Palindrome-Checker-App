
import java.util.Scanner;


public class PalindromeCheckerApp {

        // Function to check palindrome
        static boolean isPalindrome(String str) {
            int start = 0, end = str.length() - 1;

            while (start < end) {
                if (str.charAt(start) != str.charAt(end))
                    return false;
                start++;
                end--;
            }
            return true;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            // Normalize string: remove non-alphanumeric, convert to lowercase
            String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            if (isPalindrome(normalized))
                System.out.println("Palindrome");
            else
                System.out.println("Not Palindrome");

            sc.close();
        }
    }