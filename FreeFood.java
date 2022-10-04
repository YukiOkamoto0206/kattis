package week3;
import java.util.*;
public class FreeFood {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] events = new int[366];
    int N = scan.nextInt();
    for (int i = 0; i < N; i++) {
      int s = scan.nextInt();
      int t = scan.nextInt();
      for (int j = s; j <= t; j++) {
        events[j] = 1;
      }
    }
    int sum = 0;
    for (int n: events) {
      sum+=n;
    }
    System.out.println(sum);
  }
}
