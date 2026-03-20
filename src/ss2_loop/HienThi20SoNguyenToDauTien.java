package ss2_loop;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int n = 100, count = 0, N = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần hiện thị: ");
        n = scanner.nextInt();

        while (count < n){
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(N) ; i++) {
                if (N % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(N + " ");
                count++;
            }
            N++;
        }
    }
}
