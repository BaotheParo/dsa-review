class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(r, c, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '*';

        boolean found = backtrack(r + 1, c, index + 1, board, word) || 
                        backtrack(r - 1, c, index + 1, board, word) || 
                        backtrack(r, c + 1, index + 1, board, word) || 
                        backtrack(r, c - 1, index + 1, board, word);   

        board[r][c] = temp;

        return found;
    }
}