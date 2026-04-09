package ss8_clean_code.View;

import ss8_clean_code.Controller.CustomerController;
import ss8_clean_code.Entity.Customer;

import java.util.Scanner;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();
    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Quay lại menu chính");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Customer[] customers = customerController.getAll();
                    System.out.println("+----+----------------------+------------+----------------------+");
                    System.out.printf("| %-2s | %-20s | %-10s | %-20s |\n",
                            "ID", "Name", "DOB", "Address");
                    System.out.println("+----+----------------------+------------+----------------------+");
                    for (Customer customer : customers){
                        System.out.println(customer);
                    }
                    System.out.println("+----+----------------------+------------+----------------------+");
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
            }
        }
    }
}
