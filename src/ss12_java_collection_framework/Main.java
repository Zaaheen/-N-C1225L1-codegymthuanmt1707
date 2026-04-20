package ss12_java_collection_framework;

import ss12_java_collection_framework.view.CustomerView;
import ss12_java_collection_framework.view.ProductView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Khách hàng");
            System.out.println("2. Sản phẩm");
            System.out.println("3. Thoát");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                CustomerView.mainMenu();
                break;
            case 2:
                ProductView.mainMenu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    }
}
