package ss1_introduction_to_java;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        double rate = 26500;
        double usdt;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USDT cần chuyển đổi: ");
        usdt = scanner.nextDouble();
        double vnd = usdt * rate;

        System.out.println("Giá trị VNĐ: " + vnd);

    }
}
