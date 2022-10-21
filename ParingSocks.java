package week5;
import java.util.*;
public class ParingSocks {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Stack<Integer> main = new Stack<>();
    Stack<Integer> sub = new Stack<>();

    int n = scan.nextInt();
    for (int i = 0; i < n*2; i++) {
      int a = scan.nextInt();
      main.add(a);
    }
    int count= 0;
    for (int i = 0;i < 2*n; i++) {
      if (!main.isEmpty()&&!sub.isEmpty()&&main.peek().equals(sub.peek())) {
        main.pop();
        sub.pop();
        count++;
      } else if(!main.isEmpty()) {
        sub.add(main.pop());
        count++;
      } else if (!sub.isEmpty()) {
        main.add(sub.pop());
        count++;
      } else if (main.isEmpty() && sub.isEmpty()) {
        break;
      }
    }
    if (!main.isEmpty()||!sub.isEmpty()) {
      System.out.println("impossible");
    } else {
      System.out.println(count);
    }
  }
}
