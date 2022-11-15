package week9;
import java.util.*;
public class ColdPuterScience {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int count = 0;
    for (int i = 0; i < n; i++) {
      int t = scan.nextInt();
      if (t < 0) {
        count++;
      }
    }
    System.out.println(count);
  }
}
