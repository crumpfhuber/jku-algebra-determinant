import java.util.Arrays;

public class DeterminantGauss {
    public static double determinantGauss(double[][] matrix) {
        int n = matrix.length;
        double[][] mat = new double[n][];
        for (int i = 0; i < n; i++) {
            mat[i] = Arrays.copyOf(matrix[i], n);
        }
        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) {
                    pivot = j;
                }
            }
            if (i != pivot) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }
            if (mat[i][i] == 0) return 0;
            det *= mat[i][i];
            for (int j = i + 1; j < n; j++) {
                mat[i][j] /= mat[i][i];
            }
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    mat[j][k] -= mat[j][i] * mat[i][k];
                }
            }
        }
        return det;
    }

    public static void main(String[] args) {
        double[][] matrix = {
            {1, 2, 3},
            {0, 1, 4},
            {5, 6, 0}
        };
        System.out.println("Determinante (Gauss): " + determinantGauss(matrix));
    }
}
