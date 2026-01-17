import java.util.Stack;

public class RemoveDuplicate {
  public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    // while (!stack.isEmpty()) {
    // sb.append(stack.pop());
    // }
    // return sb.toString();

    // stack inheritance from Vector , so include:
    // get (int idx)
    // iterator()
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    RemoveDuplicate rd = new RemoveDuplicate();
    System.out.println(rd.removeDuplicates("abbaca"));
  }
}
