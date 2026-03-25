package ss3_method;

import java.util.Scanner;

public class SumCol {
    public static void main(String[] args) {
        double[][] matrix = inputMatrix();

        displayMatrix(matrix);

        Scanner scanner = new Scanner(System.in);
        int colIndex = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter column index: ");

        double sum = calculateColSum(matrix, colIndex);

        System.out.println("Sum of column " + colIndex + " : " + sum);
    }
    public static double[][] inputMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter columns: ");
        int col = Integer.parseInt(scanner.nextLine());

        double maxtrix[][] = new double[row][col];
        System.out.println("Enter ... :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("[" + i + "] [" + j + "]" );
                maxtrix[i][j] = Double.parseDouble(scanner.nextLine());
            }
        }
        return maxtrix;
    }
    public static void displayMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static double calculateColSum(double[][] matrix, int colSum){
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][colSum];
        }
        return sum;
    }
}
