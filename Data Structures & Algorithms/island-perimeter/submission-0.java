class Solution {
    private int bfs(int i, int j, int[][] grid, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int perimeter = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            for(int[] dir:directions){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 0){
                    perimeter++;
                } else if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return perimeter;
    }
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int perimeter = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    perimeter += bfs(i, j, grid, visited);
                }
            }
        }
        return perimeter;
    }
}