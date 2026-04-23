package ss15_exception;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhập cạnh a: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập cạnh b: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập cạnh c: ");
            int c = Integer.parseInt(scanner.nextLine());
            checkTriangle(a, b, c);
            System.out.println("Đây là 3 cạnh của một tam giác");
        } catch (NumberFormatException e){
            System.err.println("Error: Phải là số nguyên dương");
        } catch (IllegalTriangleException e){
            System.err.println("Error: Không phải hình tam giác ");
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void checkTriangle(int a, int b, int c) throws IllegalTriangleException{
        if (a <= 0 || b <= 0 || c <= 0 ){
            throw new IllegalTriangleException("Cạnh của tam giác phải là số nguyên dương");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
        }
    }
}
