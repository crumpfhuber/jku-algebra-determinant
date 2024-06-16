public class PerformanceTest {

    public static void main(String[] args) {
        long startTime, endTime;
        double[][] matrix;

        for (int size = 2; size <= 10; size++) {
            matrix = generateMatrix(size);

            startTime = System.nanoTime();
            DeterminantLaplace.determinantLaplace(matrix);
            endTime = System.nanoTime();
            System.out.println("Groesse: " + size + ", Laplace Zeit: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            DeterminantGauss.determinantGauss(matrix);
            endTime = System.nanoTime();
            System.out.println("Groesse: " + size + ", Gauss Zeit: " + (endTime - startTime) + " ns");

            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        }
    }

    private static double[][] generateMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.random();
            }
        }
        return matrix;
    }
}
