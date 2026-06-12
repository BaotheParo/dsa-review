// Bước 1: Định nghĩa cấu trúc của một Nút trên cây Trie
class TrieNode {
    // Mảng chứa 26 nhánh con tương ứng với 26 chữ cái từ a -> z
    TrieNode[] children;
    // Cờ hiệu đánh dấu đây có phải là điểm kết thúc của một từ hay không
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Tự động khởi tạo 26 ô trống (null)
        isEndOfWord = false;
    }
}

// Bước 2: Triển khai các tính năng của PrefixTree
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode(); // Nút gốc trống ban đầu
    }
    
    // Hàm chèn một từ vào cây
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a'; // Tính chỉ số index từ 0 -> 25
            
            // Nếu nhánh con tại ký tự này chưa tồn tại, ta tạo mới một Nút
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            // Dịch chuyển con trỏ xuống Nút con vừa chọn
            current = current.children[index];
        }
        // Đã đi đến chữ cái cuối cùng, chốt hạ đây là một từ hoàn chỉnh
        current.isEndOfWord = true;
    }
    
    // Hàm tìm kiếm xem từ này có tồn tại trọn vẹn trên cây không
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            // Nếu đường đi bị đứt đoạn -> Từ này không tồn tại
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        // Đi hết từ, phải kiểm tra xem nút cuối này có phải là điểm kết thúc từ không
        return current.isEndOfWord;
    }
    
    // Hàm kiểm tra xem có từ nào bắt đầu bằng tiền tố này không
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            
            // Nếu đường đi tiền tố bị đứt đoạn -> Không có từ nào thỏa mãn
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        // Đi hết chuỗi tiền tố suôn sẻ -> Trả về true
        return true;
    }
}