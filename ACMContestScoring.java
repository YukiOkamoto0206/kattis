package week4;
import java.util.*;
public class ACMContestScoring {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    HashMap<Character, Integer> map = new HashMap<>();
    int solvedCount = 0;
    int sum = 0;
    while (true) {
      int n = scan.nextInt();
      if (n == -1) {
        break;
      }

      char ch = scan.next().charAt(0);
      String result = scan.next();

      if (result.equals("wrong")) {
        if (!map.containsKey(ch)) {
          map.put(ch, 0);
        }
        map.put(ch, map.get(ch) + 1);
      } else {
        // right
        if (map.containsKey(ch)) {
          sum += (n+map.get(ch)*20);
          solvedCount++;
        } else {
          sum += n;
          solvedCount++;
        }
      }
    }
    System.out.println(solvedCount + " " + sum);
  }
}
