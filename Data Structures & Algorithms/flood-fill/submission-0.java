class Solution {
    private void dfs(int row, int col, int[][] ans, int[][] image, int color, int iniColor){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] dir:directions){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == iniColor && ans[nr][nc] != color){
                dfs(nr, nc, ans, image, color, iniColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        dfs(sr, sc, ans, image, color, iniColor);
        return ans;
    }
}