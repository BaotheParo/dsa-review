class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Điều kiện tiên quyết: Một cây có n nút bắt buộc phải có đúng n - 1 cạnh
        if (edges.length != n - 1) {
            return false;
        }

        // Bước 1: Xây dựng Danh sách kề (Adjacency List) cho đồ thị vô hướng
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Đồ thị vô hướng nên phải add cả 2 chiều
        }

        // Tập hợp đánh dấu các nút đã ghé thăm
        Set<Integer> visited = new HashSet<>();

        // Bước 2: Kích hoạt DFS thám hiểm từ nút 0
        dfs(0, adj, visited);

        // Bước 3: Nếu số nút đi qua bằng đúng n thì đồ thị liên thông -> Cây hợp lệ
        return visited.size() == n;
    }

    private void dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {
        // Đánh dấu nút hiện tại đã ghé thăm
        visited.add(node);

        // Đi thám hiểm các nút hàng xóm kề cạnh
        for (int neighbor : adj.get(node)) {
            // Nếu hàng xóm chưa được ghé thăm thì mới đi tiếp sang đó
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
