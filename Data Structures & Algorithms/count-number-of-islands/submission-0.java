class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r<rows;r++){
            for (int c= 0; c<cols;c++){
                if (grid[r][c]=='1'){
                    numIslands++;
                    sinkIslandDFS(grid,r,c);
                }
            }
        }
        return numIslands;
    }
    private void sinkIslandDFS(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        sinkIslandDFS(grid, r + 1, c);
        sinkIslandDFS(grid, r - 1, c);
        sinkIslandDFS(grid, r, c + 1);
        sinkIslandDFS(grid, r, c - 1); 
    }
}
