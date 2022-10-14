package week4;
import java.util.*;
public class BusNumbers {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    boolean[] lists = new boolean[1001];
    Arrays.fill(lists, false);
    for (int i = 0; i < n; i++) {
      int index = scan.nextInt();
      lists[index] = true;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < lists.length; i++) {
      if (!lists[i]) {
        continue;
      }
      int start = i;
      while (i+1<lists.length && lists[i+1]) {
        i++;
      }
      int stop = i;
      if (stop-start>=2) {
        sb.append(start + "-" + stop + " ");
      } else if (stop-start==1) {
        sb.append(start + " " + stop + " ");
      } else {
        sb.append(start + " ");
      }
    }

    if (sb.length() > 0){
      sb.setLength(sb.length()-1);
    } 
    System.out.println(sb);




    // for (int i = 0; i < n; i++) {
    //   int stop = scan.nextInt();
    //   lists[stop] = 1;
    // }
    // StringBuilder sb = new StringBuilder("");
    // int count = 0;
    // for (int i = 1; i < lists.length; i++) {
    //   if (lists[i] == 1) {
    //     count++;
    //     if (i==lists.length-1) {
    //       if (count >= 3) {
    //         sb.append((i-count+1) + "-" + (i) + " ");
    //       } else if (count == 2) {
    //         sb.append((i-1) + " " + (i) + " ");
    //       } else if (count == 1) {
    //         sb.append(i + " ");
    //       }
    //     }
    //     continue;
    //   } else {
    //     if (count >= 3) {
    //       sb.append((i-count) + "-" + (i-1) + " ");
    //     } else if (count == 2) {
    //       sb.append((i-2) + " " + (i-1) + " ");
    //     } else if (count == 1) {
    //       sb.append(i-1 + " ");
    //     }
    //     count = 0;
    //   }
    // }
    // if (sb.length() > 0) {
    //   sb.setLength(sb.length()-1);
    // }
    // System.out.println(sb);
  }
}
