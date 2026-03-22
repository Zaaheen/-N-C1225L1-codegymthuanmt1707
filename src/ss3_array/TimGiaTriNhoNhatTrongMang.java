package ss3_array;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        
        do {
            System.out.println("Nhập số lượng phần tử: ");
            num = scanner.nextInt();
        } while (num <= 0);

        int[] arr = new int[num];

        System.out.println("Nhập các giá trị của phần tử có trong mảng: ");
        for (int i = 0; i < num; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Mảng: " + Arrays.toString(arr));
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
    }
}
