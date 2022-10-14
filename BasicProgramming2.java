package week4;

import java.util.*;
import java.io.*;
public class BasicProgramming2 {
  static class FastReader { 
    BufferedReader br; 
    StringTokenizer st; 
    public FastReader() { 
      br = new BufferedReader( 
      new InputStreamReader(System.in)); 
    } 

    String next() { 
      while (st == null || !st.hasMoreElements()) { 
          try { 
              st = new StringTokenizer(br.readLine()); 
          } 
          catch (IOException e) { 
              e.printStackTrace(); 
          } 
      } 
      return st.nextToken(); 
    } 
    int nextInt() { return Integer.parseInt(next()); } 
    long nextLong() { return Long.parseLong(next()); } 

    double nextDouble() { 
      return Double.parseDouble(next()); 
    } 

    String nextLine() { 
      String str = ""; 
      try { 
          if(st.hasMoreTokens()){ 
              str = st.nextToken("\n"); 
          } 
          else{ 
              str = br.readLine(); 
          } 
      } 
      catch (IOException e) { 
          e.printStackTrace(); 
      } 
      return str; 
    } 
  } 

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int N = scan.nextInt();
    int t = scan.nextInt();

    Set<Integer> set = new HashSet<>();
    switch(t) {
      case 1:
        for (int i = 0; i < N; i++) {
          int num = scan.nextInt();
          int target = 7777-num;
          if (set.contains(num)) {
            System.out.println("Yes");
            System.exit(0);
          } else {
            set.add(target);
          }
        }
        System.out.println("No");
        break;
      case 2:
        for (int i = 0; i < N; i++) {
          int num = scan.nextInt();
          if (set.contains(num)) {
            System.out.println("Contains duplicate");
            System.exit(0);
          } else {
            set.add(num);
          }
        }
        System.out.println("Unique");
        break;
      case 3:
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
          int num = scan.nextInt();
          if (!map.containsKey(num)) {
            map.put(num,0);
          }
          map.put(num, map.get(num)+1);
          if (map.get(num)*2 > N) {
            System.out.println(num);
            System.exit(0);
          }
        }
        System.out.println(-1);
        break;
      case 4:
        int[] A = new int[N];
        for (int i = 0;i < N; i++) {
          A[i] = scan.nextInt();
        }
        Arrays.sort(A);
        if (N%2==1) {
          System.out.println(A[N/2]);
        } else {
          System.out.println(A[N/2-1] + " " +A[N/2]);
        }
        break;
      case 5:
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
          int num = scan.nextInt();
          if (num >= 100 && num <= 999) {
            list.add(num);
          }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
          if (i == list.size()-1) {
            System.out.print(list.get(i));
          } else {
            System.out.print(list.get(i) + " ");
          }
        }
        break;
    }
  }
  
}
