package week3;
import java.util.*;
public class Prozor {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String nums = scan.nextLine();
    StringTokenizer token = new StringTokenizer(nums);
    int R = Integer.parseInt(token.nextToken());
    int S = Integer.parseInt(token.nextToken());
    int K = Integer.parseInt(token.nextToken());
    char[][] inputGrid = new char[R+1][S+1];

    int[][] grid = new int[R+1][S+1];
    for (int i = 0; i < R; i++) {
      char[] str = scan.nextLine().toCharArray();
      for (int j = 0; j < S; j++) {
        if (str[j] == '*') {
          grid[i+1][j+1] = 1;
          inputGrid[i+1][j+1] = '*';
        } else {
          inputGrid[i+1][j+1] = '.';
        }
      }
    }

    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= S; j++) {
        grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
      }
    }

    int cur_val = 0, max_val = 0, max_i = K, max_j = K;
    for (int i = K; i <= R; i++) {
      for (int j = K; j <= S; j++) {
        cur_val = grid[i-1][j-1] - grid[i-1][j-K+1] - grid[i-K+1][j-1] + grid[i-K+1][j-K+1];
        if (max_val < cur_val) {
          max_val = cur_val;
          max_i = i;
          max_j = j;
        }
      }
    }

    System.out.println(max_val);
    for (int i = 1; i <= R; i++) {
      for (int j= 1; j <= S; j++) {
        int edge_i = max_i-K+1;
        int edge_j = max_j-K+1;
        if ((i==max_i&&j==max_j) || (i==max_i&&j==edge_j) || (i==edge_i&&j==max_j) || (i==edge_i&&j==edge_j)) { 
          System.out.print('+');
        } else if((i==edge_i||i==max_i) && (j>edge_j&&j<max_j)) {
          System.out.print('-');
        } else if((i>edge_i&&i<max_i) && (j==edge_j||j==max_j)) {
          System.out.print('|');
        } else {
          System.out.print(inputGrid[i][j]);
        }
      }
      System.out.println();
    }


  }
}
