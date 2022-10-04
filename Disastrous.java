package week2;
import java.util.*;
public class Disastrous {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    int[] array = new int[101000];
    for (int i = 0; i < n; i++) {
      int t = scan.nextInt();
      for (int j = t; j < t+1000; j++) {
        array[j] += 1;
      }
    }
    int max = 0;
    for (int i = 0; i < array.length; i++){
      if (array[i] > max) {
        max = array[i];
      }
    }
    if (max%k==0) {
      System.out.println(max/k);  
    }else {
      System.out.println(max/k+1);
    }
  }
}
