package week2;
import java.util.*;
public class LowOderZeros {
  public static void main(String[] args) {
    int[] results = new int[1000001];
    results[0] = 1;
    Scanner scan = new Scanner(System.in);
    for (int i = 1; i < results.length; i++) {
      long product = (long) results[i-1] * i;
      while (product % 10 == 0) {
        product /= 10;
      }
      results[i] = (int) (product % 1000000);
    }
    int num = scan.nextInt();
    while (num != 0) {
      System.out.println(results[num]%10);
      num = scan.nextInt();
    }
  }
}
