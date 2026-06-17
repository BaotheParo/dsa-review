class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Bước 1: Xây dựng Đồ thị dưới dạng Danh sách kề (Adjacency List)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];
            // preCourse phải học trước -> trỏ tới course học sau
            adj.get(preCourse).add(course);
        }

        // Mảng lưu trạng thái: 0 = Chưa xét, 1 = Đang xét, 2 = Đã xét xong an toàn
        int[] visited = new int[numCourses];

        // Bước 2: Duyệt qua từng môn học để kích hoạt DFS kiểm tra chu trình
        for (int i = 0; i < numCourses; i++) {
            // Nếu phát hiện có vòng lặp tại bất kỳ nhánh nào, trả về false ngay
            if (hasCycleDFS(i, adj, visited)) {
                return false;
            }
        }

        return true; // Đi qua hết đồ thị suôn sẻ không gặp vòng lặp -> Hợp lệ
    }

    private boolean hasCycleDFS(int course, List<List<Integer>> adj, int[] visited) {
        // Nếu gặp lại một môn ĐANG TRONG QUÁ TRÌNH XỬ LÝ -> Phát hiện chu trình!
        if (visited[course] == 1) {
            return true;
        }
        // Nếu môn này đã được kiểm duyệt an toàn từ trước -> Không cần xét lại
        if (visited[course] == 2) {
            return false;
        }

        // Bước 1: Đánh dấu môn hiện tại là ĐANG XỬ LÝ (Trạng thái 1)
        visited[course] = 1;

        // Bước 2: Đi thám hiểm tất cả các môn học sau của nó
        for (int nextCourse : adj.get(course)) {
            if (hasCycleDFS(nextCourse, adj, visited)) {
                return true;
            }
        }

        // Bước 3: Sau khi thám hiểm hết các nhánh con an toàn, 
        // chuyển môn này sang trạng thái ĐÃ XỬ LÝ XONG (Trạng thái 2)
        visited[course] = 2;

        return false;
    }
}
