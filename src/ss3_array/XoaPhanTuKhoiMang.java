package ss3_array;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] number = {10, 4, 6, 7, 8, 6, 1, 2, 3, 5};
        System.out.println(Arrays.toString(number));
        System.out.println("Nhập số muốn xoá khỏi mảng: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < number.length ; i++) {
            if (n == number[i]) {
                int index_del = i;
                System.out.println("Tim thấy " + n + " tại vị trí index " + index_del);

                for (int j = index_del; j < number.length - 1; j++) {
                    number[j] = number[j + 1];
                }

                number[number.length - 1] = 0;
                i--;
            }
        }
        System.out.println("Mảng mới: " + Arrays.toString(number));
    }
}
