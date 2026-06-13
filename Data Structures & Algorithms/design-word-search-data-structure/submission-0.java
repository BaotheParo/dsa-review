class WordDictionary {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return match(word, 0, root);
    }

    private boolean match(String word, int index, TrieNode current) {
        if (index == word.length()) {
            return current.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    if (match(word, index + 1, current.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int nodeIndex = c - 'a';
            if (current.children[nodeIndex] == null) {
                return false;
            }
            return match(word, index + 1, current.children[nodeIndex]);
        }
    }
}