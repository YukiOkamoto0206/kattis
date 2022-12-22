class NumMatrix {

    int[][] convertedMatrix;

    public NumMatrix(int[][] matrix) {
        convertedMatrix = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                convertedMatrix[i+1][j+1] = matrix[i][j];
            }
        }

        for (int i = 1; i < convertedMatrix.length; i++) {
            for (int j = 1; j < convertedMatrix[0].length; j++) {
                convertedMatrix[i][j] = convertedMatrix[i][j] + convertedMatrix[i][j-1] + convertedMatrix[i-1][j] - convertedMatrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return convertedMatrix[row2][col2] - convertedMatrix[row2][col1-1] - convertedMatrix[row1-1][col2] + convertedMatrix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// 1, 1, 1, 1
// 1, 1, 1, 1
// 1, 1, 1, 1
// 1, 1, 1, 1

// 1, 2, 3, 4
// 2, 4, 6, 8 // 2+2+(1自分)-1(0,0), 3+4+1-2
// 3, 6, 9, 12 // 3+4+1-2, 6+6+1-4
// 4, 8, 12, 16
