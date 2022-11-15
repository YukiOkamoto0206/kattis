package week9;
import java.util.*;
public class MissingNumbers {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    int n = scan.nextInt();
    int count = 0;

    boolean isGood = true;
    for (int i = 0; i < n; i++) {
      int compare = scan.nextInt();
      if (compare > ++count) {
        while (compare > count) {
          System.out.println(count++);
          isGood = false;
        }
      }
    }
    if (isGood) {
      System.out.println("good job");
    }
  }
}
