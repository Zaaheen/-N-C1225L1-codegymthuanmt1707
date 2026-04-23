package ss14_algorithm_sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = inputArray();
        System.out.println("Mảng ban đầu: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Mảng đã sắp xếp: " + Arrays.toString(array));

    }
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử có trong mảng: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tủ thứ [" + i + "]: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        return array;
    }
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.println("Bước " + i + ": Xét giá trị key = " + key);

            while (j >= 0 && array[j] > key) {
                System.out.println("  -> Đẩy " + array[j] + " sang phải");
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            System.out.println("  => Chèn " + key + " vào vị trí index " + (j + 1));
            System.out.println("Mảng hiện tại: " + Arrays.toString(array));
        }
    }
}
