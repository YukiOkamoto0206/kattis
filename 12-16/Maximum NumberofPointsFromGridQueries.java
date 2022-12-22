class Solution {
    boolean[][] visited;
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] answer = new int[queries.length];
        int[][] saved = new int[grid.length][grid[0].length];
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < saved.length; i++) {
            for (int j = 0; j < saved[0].length; j++) {
                saved[i][j] = grid[i][j];
            }
        }

        for (int k = 0; k < queries.length; k++) {
            int query = queries[k];
            if (query > grid[0][0]) {
                answer[k] = dfs(grid, 0, 0, query);
            } else {
                answer[k] = 0;
            }
            for (int i = 0; i < saved.length; i++) {
                for (int j = 0; j < saved[0].length; j++) {
                    grid[i][j] = saved[i][j];
                }
            }
        }
        return answer;
    }

    public int dfs(int[][] grid, int i, int j, int query) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] > query || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(grid, i-1, j, query) + dfs(grid, i+1, j, query)+ dfs(grid, i, j-1, query) + dfs(grid, i, j+1, query);
    }
}
//queries is bigger than others.
