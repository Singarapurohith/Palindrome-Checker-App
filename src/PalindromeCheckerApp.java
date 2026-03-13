import java.util.*;

public class PalindromeCheckerApp {
    static void main( String[] args) {


                Scanner sc = new Scanner(System.in);

                Queue<Character> queue = new LinkedList<>();
                Stack<Character> stack = new Stack<>();

                System.out.print("Enter a string: ");
                String str = sc.nextLine();

                // Insert characters into queue and stack
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    queue.add(ch);     // Enqueue
                    stack.push(ch);    // Push
                }

                boolean isPalindrome = true;

                // Compare dequeue and pop
                for (int i = 0; i < str.length(); i++) {

                    if (queue.remove() != stack.pop()) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome)
                    System.out.println("Palindrome");
                else
                    System.out.println("Not Palindrome");

                sc.close();
            }
        }