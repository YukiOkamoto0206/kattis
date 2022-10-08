package week3;
import java.util.*;
public class FreeFood {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] events = new int[366];
    int N = scan.nextInt();
    
//  brute force: O(N*events.length)
//     for (int i = 0; i < N; i++) {
//       int s = scan.nextInt();
//       int t = scan.nextInt();
//       for (int j = s; j <= t; j++) {
//         events[j] = 1;
//       }
//     }
//     int sum = 0;
//     for (int n: events) {
//       sum+=n;
//     }
//     System.out.println(sum);
    

// Prefix sum: O(N+events.length)    
    for (int i = 0; i < N; i++) {
      int s = scan.nextInt();
      int t = scan.nextInt();
      ++events[s-1];
      --events[t];
    }

    // prefix sum
    for (int i = 1; i < events.length; i++) {
      events[i] += events[i-1];
    }

    int answer = 0;
    for (int count: events) {
      if (count > 0 ) {
        answer++;
      } 
    }
    System.out.println(answer);
  }
}
