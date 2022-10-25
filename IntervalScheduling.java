package week6;
import java.util.*;
public class IntervalScheduling {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int[][] intervals = new int[n][2];
    for (int i = 0; i < n; i++) {
      intervals[i][0] = scan.nextInt();
      intervals[i][1] = scan.nextInt();
    }
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

    int count = 0;
    int start = 0;
    for (int i = 0; i < n; i++) {
      if (intervals[i][0] >= start) {
        count++;
        start = intervals[i][1];
      }
    }
    System.out.println(count);
  }
}
