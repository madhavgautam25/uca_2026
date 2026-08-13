import java.util.Scanner;

public class MatrixZeros {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Checking if first row has zero
        for(int j = 0; j < cols; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Checking if first column has zero
        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {

                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < rows; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < cols; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero) {
            for(int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {

        System.out.println("=====================Updated matrix===================");

        for(int[] row : matrix) {
            for(int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the order of matrix: ");
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];

        System.out.println("===============Enter the elements of Matrix===============");
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){

                matrix[i][j] = sc.nextInt();
            }
        }

        setZeroes(matrix);

        printMatrix(matrix);
    }
}