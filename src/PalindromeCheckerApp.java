import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// 1. Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// 2. Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// 3. Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// 4. Context
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("PalindromeStrategy not set!");
        }
        return strategy.isPalindrome(input);
    }
}

// 5. Main
class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String test = "A man a plan a canal Panama";

        // Stack strategy
        checker.setStrategy(new StackStrategy());
        System.out.println("StackStrategy: " + checker.check(test));

        // Deque strategy
        checker.setStrategy(new DequeStrategy());
        System.out.println("DequeStrategy: " + checker.check(test));
    }
}