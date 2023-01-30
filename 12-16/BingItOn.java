import java.util.*;
public class BingItOn {

  private class Node {
    private char val;
    private int count;
    private Node[] children;

    public Node(char c) {
      this.val = c;
      this.count = 0;
      this.children = new Node[26]; // num of alphabets
    }
  }

  private Node root;
  
  public BingItOn() {
    this.root = new Node(' ');
  }

  public void insert(String word) {
    Node current = root;

    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (current.children[index] == null) {
        current.children[index] = new Node(word.charAt(i));
      }
      current = current.children[index];
      current.count++;
    }
  }

  public int search(String prefix) {
    Node current = root;

    for (int i = 0; i < prefix.length(); i++) {
      int index = prefix.charAt(i) - 'a';
      if (current.children[index] == null) {
        return 0;
      }
      current = current.children[index];
    }

    return current.count;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    BingItOn trie = new BingItOn();
    for (int i = 0; i < n; i++) {
      String word = scan.next();
      int answer = trie.search(word);
      System.out.println(answer);
      trie.insert(word);
    }
  }
}
