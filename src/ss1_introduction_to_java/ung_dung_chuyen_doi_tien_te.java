package ss1_introduction_to_java;

import java.util.Scanner;

public class ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        double vnd = 26500;
        double usdt;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USDT cần chuyển đổi: ");
        usdt = scanner.nextDouble();
        double rate = usdt * vnd;

        System.out.println("Giá trị VNĐ: " + rate);

    }
}
