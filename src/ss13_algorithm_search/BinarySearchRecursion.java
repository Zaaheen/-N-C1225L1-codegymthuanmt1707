package ss13_algorithm_search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = inputArray();
        Arrays.sort(array);
        System.out.println("Mảng sau khi đã sắp xếp: " + Arrays.toString(array));
        System.out.print("Nhập giá trị cần tìm: ");
        int value = Integer.parseInt(scanner.nextLine());
        int result = binarySearch(array, 0, array.length - 1, value);
        if (result == -1){
            System.out.println("Không tìm thấy " + value);
        } else {
            System.out.println("Phần tử " + value + " nằm tại vị trí index: " + result);
        }
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
    public static int binarySearch(int[] array, int left, int right, int value){
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (array[mid] == value) return mid;
        if (value > array[mid]) return binarySearch(array, mid + 1, right, mid);
        if (value < array[mid]) return binarySearch(array, left, mid - 1, mid);
        return 0;
    }
}
