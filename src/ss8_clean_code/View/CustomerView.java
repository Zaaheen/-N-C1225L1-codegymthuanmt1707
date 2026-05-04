package ss8_clean_code.View;

import ss8_clean_code.Controller.CustomerController;
import ss8_clean_code.Entity.Customer;


import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();
    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Tìm kiếm khách hàng");
            System.out.println("5. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    List<Customer> customers = customerController.getAll();
                    displayCustomer(customers);
                    break;
                case 2:
                    System.out.print("Nhập id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String dob = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    customerController.add(new Customer(id, name, dob, address));
                    System.out.println("Thêm thành công");
                    break;
                case 3:
                    System.out.print("Nhập id cần xoá: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    customerController.delete(delId);
                    System.out.println("Xoá thành công");
                    break;
                case 4:
                    System.out.print("Nhập tên khách hàng cần tìm: ");
                    String findName = scanner.nextLine();
                    List<Customer> result = customerController.getByName(findName);
                    displayCustomer(result);
                    break;
                case 5:
                    System.exit(1);
                    break;
            }
        }
    }

    public static void displayCustomer(List<Customer> customers) {
        if (customers.isEmpty()){
            System.out.println("Không tồn tại");
            return;
        }
        System.out.println("+----+----------------------+------------+----------------------+");
        System.out.printf("| %-2s | %-20s | %-10s | %-20s |\n",
                "ID", "Name", "DOB", "Address");
        System.out.println("+----+----------------------+------------+----------------------+");
        for (Customer customer : customers){
            System.out.println(customer);
        }
        System.out.println("+----+----------------------+------------+----------------------+");
    }
}
