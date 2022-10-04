package week3;
import java.util.*;
public class ICanGuessTheDataStructure {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while (scan.hasNext()) {
      int n = scan.nextInt();
      boolean isStack = true;
      Stack<Integer> stack = new Stack<>();
      boolean isQueue = true;
      Queue<Integer> queue = new LinkedList<>();
      boolean isPriority = true;
      PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

      for (int i = 0; i < n; i++) {
        int num = scan.nextInt();
        int x = scan.nextInt();

        if (num==1) {
          stack.push(x);
          queue.add(x);
          priority.add(x);
        } else if (num==2) {
          if (stack.isEmpty() || stack.pop()!=x) {
            isStack = false;
          }
          if (queue.isEmpty() || queue.poll()!=x) {
            isQueue = false;
          }
          if (priority.isEmpty() || priority.poll()!=x) {
            isPriority = false;
          }
        }
      }

      if (!isStack && !isQueue && !isPriority) {
        System.out.println("impossible");
      } else if (isStack && !(isQueue || isPriority)) {
        System.out.println("stack");
      } else if (isQueue && !(isStack || isPriority)) {
        System.out.println("queue");
      } else if (isPriority && !(isStack || isQueue)) {
        System.out.println("priority queue");
      } else {
        System.out.println("not sure");
      }
    }
  }
}
