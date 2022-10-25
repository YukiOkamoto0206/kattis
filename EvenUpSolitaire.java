package week6;
import java.util.*;
public class EvenUpSolitaire {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    Stack<Integer> main = new Stack<>();
    Stack<Integer> sub = new Stack<>();
    for (int i = 0; i < n; i++) {
      main.add(scan.nextInt());
    }

    while (!main.isEmpty()) {
      if (sub.isEmpty()) {
        sub.add(main.pop());
        continue;
      }

      int top_main = main.peek();
      int top_sub = sub.peek();
      if ((top_main+top_sub) % 2 == 0) {
        main.pop();
        sub.pop();
      } else {
        sub.add(main.pop());
      }
    }
    System.out.println(sub.size());
  }
}
