package ss2_loop;

import java.util.Arrays;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
//        System.out.println("Các số nguyên tố từ 2 đến 100 là: ");
//
//        for (int i = 2; i <= 100 ; i++) {
//            boolean isPrime = true;
//
//            for (int j = 2; j <= Math.sqrt(i) ; j++) {
//                if (i % 2 == 0){
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime){
//                System.out.print(i + " ");
//            }

        // Thuật toán Sàng Eratosthenes
        int n = 100;
        boolean[] isPrime = new boolean[100 + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        System.out.println("Các số nguyên tố từ 2 đến 100 là: ");
        for (int i = 2; i <= n ; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
