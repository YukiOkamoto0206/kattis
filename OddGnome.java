package week1;
import java.util.*;
public class OddGnome {
  public static void main() {
    Scanner scan = new Scanner(System.in);
    int num = Integer.parseInt(scan.nextLine());
    for (int i = 0; i < num; i++) {
      String g_str = scan.nextLine();
      String[] g_strs = g_str.split(" ");
      int king = Integer.parseInt(g_strs[1]);
      for (int j = 2; j < g_strs.length - 1; j++) {
        int input_num = Integer.parseInt(g_strs[j]);
        if (king + 1 != input_num) {
          if (j == 2 && g_strs.length > 3) {
            if (input_num + 1 == Integer.parseInt(g_strs[j+1])) {
              System.out.println(1);
              break;
            }
          }
          System.out.println(j);
          break;
        }
        king = input_num;
      }
    }
  }
}
