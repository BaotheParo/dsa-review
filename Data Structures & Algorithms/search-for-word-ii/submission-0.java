class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String w : words){
            TrieNode current = root;
            for (char c : w.toCharArray()){
                int index = c - 'a';
                if (current.children[index] == null){
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r<rows; r++){
            for (int c = 0; c<cols; c++){
                dfs(board,r,c,root,result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode current, List<String> result){
        if (r<0 || r>= board.length || c<0 || c>=board[0].length){
            return;
        }
        char ch = board[r][c];
        if (ch == '*' || current.children[ch-'a']==null){
            return;
        }

        current = current.children[ch - 'a'];
        if (current.word != null){
            result.add(current.word);
            current.word = null;
        }
        board[r][c]='*';
        dfs(board, r+1, c, current, result);
        dfs(board, r-1, c, current, result);
        dfs(board, r, c+1, current, result);
        dfs(board, r, c-1, current, result);
        board[r][c]=ch;
    }
}
