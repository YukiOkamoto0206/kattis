// first solution which does not work
// class Solution {

//     public static int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
//     public boolean exist(char[][] board, String word) {
//         char[] ch_word = word.toCharArray();
//         int point = 0;

//         // convert A to *
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 if (ch_word[0] == board[i][j]) {
//                     boolean isFound = dfs(i, j, board, point, ch_word);
//                     if (isFound) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
//     public boolean dfs(int i, int j, char[][] board, int point, char[] ch_word) {
//         if (point == ch_word.length-1) {
//             return true;
//         }

//         for (int[] direction: DIRECTIONS) {
//             int x = i + direction[0];
//             int y = j + direction[1];

//             if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
//                 if (board[x][y] == ch_word[point+1]) {
//                     board[x][y] = '*';
//                     dfs(x, y, board, point+1, ch_word);
//                 }
//             }
//             if (x == board.length-1 && y==board[0].length-1) {
//                 return false;
//             }
//         }
//         return false;
//     }
// }



// answer
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, char[][] board, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = ' ';
        boolean isFound = dfs(i-1, j, board, index+1, word)
                       || dfs(i+1, j, board, index+1, word)
                       || dfs(i, j-1, board, index+1, word)
                       || dfs(i, j+1, board, index+1, word);
        board[i][j] = word.charAt(index);
        return isFound;
    }
}
