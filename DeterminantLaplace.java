public class DeterminantLaplace {

    public static double determinantLaplace(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        double det = 0;
        for (int i = 0; i < n; i++) {
            double[][] subMatrix = getSubMatrix(matrix, 0, i);
            det += Math.pow(-1, i) * matrix[0][i] * determinantLaplace(subMatrix);
        }
        return det;
    }

    private static double[][] getSubMatrix(double[][] matrix, int excludingRow, int excludingCol) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (i == excludingRow) continue;
            r++;
            int c = -1;
            for (int j = 0; j < n; j++) {
                if (j == excludingCol) continue;
                subMatrix[r][++c] = matrix[i][j];
            }
        }
        return subMatrix;
    }

    public static void main(String[] args) {
        double[][] matrix = {
            {1, 2, 3},
            {0, 1, 4},
            {5, 6, 0}
        };
        System.out.println("Determinante (Laplace): " + determinantLaplace(matrix));
    }
}
