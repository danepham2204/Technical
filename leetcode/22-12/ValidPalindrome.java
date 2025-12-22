public class ValidPalindrome {
  // A palindrome is a string that reads the same forward and backward. It is also
  // case-insensitive and ignores all non-alphanumeric characters.
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {

    }
  }

  public static void main(String[] args) {
    ValidPalindrome solution = new ValidPalindrome();
    String s = "racecar";
    boolean result = solution.isPalindrome(s);
    System.out.println("Is palindrome: " + result);
  }
}