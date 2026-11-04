class NumMatrix {
    
    private int[][] pre;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        pre = new int[rows + 1][cols + 1];

        for(int r = 0; r < rows; r++){
            int prefix = 0;
            for(int c = 0; c < cols; c++){
                prefix += matrix[r][c];
                pre[r + 1][c + 1] = prefix + pre[r][c + 1];
            }
        }    
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int bottomRight = pre[row2][col2];
        int above = pre[row1 - 1][col2];
        int left = pre[row2][col1 - 1];
        int topLeft = pre[row1 - 1][col1 - 1];
        
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */