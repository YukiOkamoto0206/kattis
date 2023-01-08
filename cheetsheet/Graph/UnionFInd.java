class Solution {
    int[] parent;
  
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x==y) {
            return;
        }
        parent[x] = y;
    }
}
