class Solution {
    private void dfs(int row, int col, int[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir:directions){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && vis[nr][nc] == 0){
                dfs(nr, nc, vis, grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    cnt++;
                    dfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
}
