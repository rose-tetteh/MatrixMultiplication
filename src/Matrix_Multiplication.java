import java.util.Scanner;

public class Matrix_Multiplication {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Get matrix int [ ] [ ].
     *
     * @param row    the row
     * @param column the column
     * @return the int [ ] [ ]
     */
    public static int[][] getMatrix(int row, int column){
        int[][] matrix = new int[row][column];
        System.out.println("Enter the values of the matrix row by row: eg 2 3 4 go to the next line and enter values for the next row: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    /**
     * Validation int.
     *
     * @return the int
     */
    public static int validation(){
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input (Should be an integer)!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Multiply matrix int [ ] [ ].
     *
     * @param matrix1 the matrix 1
     * @param matrix2 the matrix 2
     * @return the int [ ] [ ]
     */
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;

//     int r2 = matrix2.length;
        int c2 = matrix2[0].length;
        int[][] finMatrix = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    finMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return finMatrix;
    }

    /**
     * Verify matrix multiplication int.
     *
     * @param column1 the column 1
     * @param row2    the row 2
     * @return the int
     */
    public static int verifyMatrixMultiplication(int column1, int row2){
        while (row2 != column1) {
            System.out.println("Matrix multiplication is not possible. Number of columns for matrix A should be the same as number of rows for matrix B");
            System.out.println("Enter the number of rows for the second matrix again: ");
            row2 = validation();
        }
        return row2;
    }

    /**
     * Print matrix.
     *
     * @param matrix the matrix
     */
    public static void printMatrix(int[][] matrix){
        System.out.println("\nsMatrix C:");
        for(int[] row: matrix){
            System.out.print("| ");
            for(int value :row){
                System.out.printf("%2d ", value);
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows and number of columns of the first matrix respectively eg 2 3: ");
        int rowA = validation();
        int columnA = validation();
        int[][] matrixA = getMatrix(rowA,columnA);

        System.out.println("Enter the number of rows and number of columns of the second matrix respectively eg 2 3: ");
        int rowB = validation();
        int columnB = validation();

        rowB = verifyMatrixMultiplication(columnA, rowB);

        int[][] matrixB = getMatrix(rowB,columnB);

        int[][] matrixC = multiplyMatrix(matrixA,matrixB);

        printMatrix(matrixC);

        scanner.close();
    }

}
