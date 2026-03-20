package ss2_loop;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố từ 2 đến 100 là: ");

        for (int i = 2; i <= 100 ; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i) ; j++) {
                if (i % 2 == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " ");
            }
        }
    }
}
