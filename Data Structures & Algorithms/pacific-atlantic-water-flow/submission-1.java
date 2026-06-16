class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length==0 || heights[0].length == 0){
            return result;
        }
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        for(int c= 0; c<cols;c++){
            dfs(0, c, pacificVisited, heights[0][c], heights);
            dfs(rows-1, c, atlanticVisited, heights[rows - 1][c], heights);
        }
        for(int r = 0; r < rows; r++){
            dfs(r, 0, pacificVisited, heights[r][0], heights); 
            dfs(r, cols - 1, atlanticVisited, heights[r][cols - 1], heights); 
        }
        for(int r = 0; r<rows;r++){
            for(int c = 0; c<cols; c++){
                if (pacificVisited[r][c] && atlanticVisited[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }
    private void dfs(int r, int c, boolean[][] visited, int prevHeight, int[][] heights) {
       if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length 
            || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(r + 1, c, visited, heights[r][c], heights); 
        dfs(r - 1, c, visited, heights[r][c], heights);
        dfs(r, c + 1, visited, heights[r][c], heights); 
        dfs(r, c - 1, visited, heights[r][c], heights); 
    }
}
