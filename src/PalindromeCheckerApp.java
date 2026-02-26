public class PalindromeCheckerApp {
    static void main( String[] args) {
        String word = "radar";
        char[] chars = word.toCharArray();
        boolean isPalindrome = true;
        int end = chars.length-1;
        int start = 0;
        while (start < end) {
            if(word.charAt(end)!= word.charAt(start)){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        }else{
            System.out.println(word + " is a not palindrome");
        }

    }
}