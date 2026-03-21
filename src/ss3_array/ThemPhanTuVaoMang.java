package ss3_array;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] number = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println(Arrays.toString(number));
        System.out.println("Nhập số muốn thêm vào mảng: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Nhập vị trí muốn thêm vào mảng: ");
        int index_add = scanner.nextInt();

        if (index_add < 0 || index_add > number.length) {
            System.out.println("Vị trí không hợp lệ");
        } else {
            for (int i = number.length - 1; i > index_add ; i--) {
                number[i] = number[i - 1];
            }
            number[index_add] = n;
        }
        System.out.println("Mang mới: " + Arrays.toString(number));
    }

}
