package ss8_clean_code;

import ss8_clean_code.View.CustomerView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với ứng dụng quản lý CodeGym");
        while (true) {
            System.out.println("1. Quản lý khách hàng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CustomerView.mainMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(1);

            }
        }
    }
}
