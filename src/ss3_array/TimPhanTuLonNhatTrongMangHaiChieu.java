package ss3_array;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col, row;

        do {
            System.out.println("Nhập số hàng: ");
            row = scanner.nextInt();
        } while (row <= 0);
        do {
            System.out.println("Nhập số cột: ");
            col = scanner.nextInt();
        } while (col <= 0);

        double[][] matrix = new double[row][col];

        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Phần tử tại [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double max = matrix[0][0];
        int rowMax = 0;
        int colMax = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] > max){
                    max = matrix[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }

        System.out.println("Phần tử lớn nhất là: " + max);
        System.out.println("Tọa độ tại: [" + rowMax + "][" + colMax + "]");
    }
}
