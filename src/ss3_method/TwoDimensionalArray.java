package ss3_method;

import java.util.Scanner;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        double[][] matrix = inputMatrix();
        displayMatrix(matrix);
        double total = calculateMatrix(matrix);
        System.out.println("Total of main diagonal:" + total);
    }
    public static double[][] inputMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ... :");
        int n = Integer.parseInt(scanner.nextLine());

        double maxtrix[][] = new double[n][n];
        System.out.println("Enter ... :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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
    public static double calculateMatrix(double[][] matrix){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
