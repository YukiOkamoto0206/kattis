package template;
import java.util.*;
public class e {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    char last = '1';
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String word = scan.next();
      if (set.contains(word)) {
        System.out.println("Player " + (i%2 + 1) + " lost");
        System.exit(0);
      } else {
        set.add(word);
      }
      if (i != 0) {
        if (last != word.charAt(0)) {
          System.out.println("Player " + (i%2 + 1) + " lost");
          System.exit(0);
        }
      }
      last = word.charAt(word.length() - 1);
    }
    System.out.println("Fair Game");
  }
}
